//
//  CoinRowView.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 31.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import Kingfisher

struct CoinRowView: View {
    var coin: Coin
    
    var body: some View {
        HStack {
            
            KFImage.url(URL(string: coin.icon ?? ""))
                .resizable()
                .fade(duration: 0.25)
                .frame(width: 50, height: 50)
                .padding(16)
            
            VStack(alignment: .leading) {
                HStack {
                    Text(coin.name ?? "")
                        .frame(alignment: .leading)
                    Text("$\(coin.price?.roundToPlaces(places: 2) ?? 0)")
                        .frame(alignment: .leading)
                }
                
                Text(coin.websiteUrl ?? "")
                    .frame(alignment: .leading)
                    .font(.footnote)
                    .padding(.top, 4)
            }
        }
    }
}
