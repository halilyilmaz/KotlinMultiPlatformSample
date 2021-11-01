//
//  ApiSampleView.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 30.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import Combine

struct ApiSampleView: View {
    @EnvironmentObject var viewModel: ApiSampleViewModel
    
    var body: some View {
        containerView
    }
    
    private var containerView: some View {
        NavigationView {
            ZStack {
                listView
            }
            .navigationTitle("Api Sample")
        }
        .onAppear {
            viewModel.fetchCoins()
        }
    }
    
    private var listView: some View {
        ScrollView {
            LazyVStack(alignment: HorizontalAlignment.leading, spacing: 5, content: {
                ForEach(viewModel.coins) { coin in
                    CoinRowView(coin: coin)
                }
            })
        }
    }
}

final class ApiSampleViewModel: ObservableObject {
    private let coinstatsAPI = CoinstatsAPI()
    
    @Published var coins: [Coin] = []
    
    func fetchCoins() {
        coinstatsAPI.fetchCoins { coinList in
            self.coins = coinList.coins
        } failure: { error in
            
        }
    }
}
