//
//  TabView.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 30.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI

enum TabItem: Int {
    case api
    case sqlite
    case userDefaults
    case other
}

struct BaseTabView: View {
    @State var selectedTab: Int = 1
    
    var body: some View {
        TabView(selection: $selectedTab, content: {
            ApiSampleView()
                .environmentObject(ApiSampleViewModel())
                .tabItem {
                    Label("API", systemImage: "list.dash")
                }
                .tag(TabItem.api)
            
            SQLiteSampleView()
                .environmentObject(SQLiteSampleViewModel())
                .tabItem {
                    Label("SQLite", systemImage: "list.dash")
                }
                .tag(TabItem.sqlite)
            
            UserDefaultSampleView()
                .environmentObject(UserDefaultSampleViewModel())
                .tabItem {
                    Label("UserDefaults", systemImage: "person")
                }
                .tag(TabItem.userDefaults)
            
            ContentView()
                .tabItem {
                    Label("SQLite", systemImage: "list.dash")
                }
                .tag(TabItem.other)
        })
    }
}
