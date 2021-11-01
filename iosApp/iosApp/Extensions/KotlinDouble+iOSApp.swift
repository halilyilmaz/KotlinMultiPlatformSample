//
//  KotlinDouble+iOSApp.swift
//  iosApp
//
//  Created by Halil İbrahim Yılmaz on 31.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

extension KotlinDouble {
    func roundToPlaces(places: Int) -> KotlinDouble {
        let divisor = pow(10.0, Double(places))
        return KotlinDouble(value: round(Double(self) * divisor) / divisor)
    }
}
