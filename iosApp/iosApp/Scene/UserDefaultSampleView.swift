//
//  UserDefaultSampleView.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 31.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import Combine

struct UserDefaultSampleView: View {
    @EnvironmentObject var viewModel: UserDefaultSampleViewModel
    @State var value: String = ""
    
    var body: some View {
        containerView
    }
    
    private var containerView: some View {
        NavigationView {
            VStack {
                TextField("", text: $value)
                    .placeholder(when: value.isEmpty) {
                        Text("VALUE")
                            .foregroundColor(.gray)
                    }
                    .padding(.leading, 15)
                
                Button(action: {
                    viewModel.saveParameter(value: value)
                }, label: {
                    Text("Save")
                })
                
                Spacer()
                
                HStack {
                    Text("SAVED VALUE: ")
                    
                    Text(viewModel.savedParameter)
                    
                    Spacer()
                }
                
                Spacer()
                
            }
            .navigationTitle("User Defaults Sample")
        }
        .onAppear {
            
        }
    }
}

final class UserDefaultSampleViewModel: ObservableObject {
    private var storage = KeyValueStorageFactory().createDriver()
    private let key = "keyName"
    
    @Published var savedParameter: String = ""
    
    func saveParameter(value: String) {
        storage.putString(key: key, value: value)
        savedParameter = getParameter() ?? "-"
    }
    
    func getParameter() -> String? {
        return storage.getStringOrNull(key: key)
    }
}
