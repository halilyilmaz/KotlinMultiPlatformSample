//
//  UserRowView.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 31.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct UserRowView: View {
    var user: User
    
    var body: some View {
        containerView
    }
    
    private var containerView: some View {
        VStack(alignment: .leading, spacing: 5) {
            HStack(spacing: 10) {
                Text("UserName: ")
                Text(user.name)
                    .frame(alignment: .leading)
                
                Spacer()
            }
            
            HStack {
                Text("LastName: ")
                Text(user.last_name)
                    .multilineTextAlignment(.leading)
                
                Spacer()
            }
        }
        .padding(.leading, 15)
        .frame(height: 60)
    }
}
