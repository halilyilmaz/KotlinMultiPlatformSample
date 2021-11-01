//
//  SQLiteView.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 31.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import Combine

struct SQLiteSampleView: View {
    @EnvironmentObject var viewModel: SQLiteSampleViewModel
    @State var name: String = ""
    @State var lastname: String = ""
    
    var body: some View {
        containerView
    }
    
    private var containerView: some View {
        NavigationView {
            VStack {
                TextField("", text: $name)
                    .placeholder(when: name.isEmpty) {
                        Text("Name")
                            .foregroundColor(.gray)
                    }
                    .padding(.leading, 15)
                
                TextField("", text: $lastname)
                    .placeholder(when: lastname.isEmpty) {
                        Text("Last name")
                            .foregroundColor(.gray)
                    }
                    .padding(.leading, 15)
                
                Button(action: {
                    viewModel.insertUser(name: name, lastName: lastname)
                    viewModel.fetchUsers()
                }, label: {
                    Text("Insert New User")
                })
                
                listView
            }
            .navigationTitle("SQLite Sample")
        }
        .onAppear {
            viewModel.fetchUsers()
        }
    }
    
    private var listView: some View {
        ScrollView {
            LazyVStack(alignment: .leading, spacing: 5, content: {
                ForEach(viewModel.users) { user in
                    UserRowView(user: user)
                }
            })
        }
    }
}

final class SQLiteSampleViewModel: ObservableObject {
    private let db = MembersRepository(databaseDriverFactory: DatabaseDriverFactory())
    
    @Published var users: [User] = []
    
    func fetchUsers() {
        let users = db.selectAllUsers()
        self.users = users
    }
    
    func insertUser(name: String, lastName: String) {
        db.insertUser(name: name, lastName: lastName)
    }
}


