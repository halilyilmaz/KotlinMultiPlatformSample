import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    let db = MembersRepository(databaseDriverFactory: DatabaseDriverFactory())
    let coinstatsAPI = CoinstatsAPI()
    // let storage = SettingConfig(settings: <#T##Multiplatform_settingsSettings#>, key: <#T##String#>, defaultValue: <#T##_?#>)
    
    var body: some View {
        VStack {
            Text(greet)
            
            Button(action: {
                
                let members = self.db.fetchAllMembers()
                print("members \(members)")
            }, label: {
                Text("Fetch")
            })
            
            Button(action: {
                
                self.db.insertMember(id: 1111, name: "Halil", avatar: "Yılmaz")
                print("inserted")
            }, label: {
                Text("Insert")
            })
            
            Button(action: {
                
                let member = self.db.select(id: 1111)
                print("inserted \(member?.login) - \(member?.avatarUrl)")

            }, label: {
                Text("Insert")
            })
            
            Button(action: {
                // self.db.insertUser()
            }, label: {
                Text("USER INSERT")
            })
            
            Button(action: {
                self.coinstatsAPI.fetchCoins { (coins) in
                    print("COINS \(coins)")
                } failure: { (error) in
                    print("ERROR \(error?.description())")
                }

            }, label: {
                Text("USER INSERT")
            })
            
            Button(action: {
            /*
                let keyValue = KeyValueStorage()
                let factory = KeyValueStorageFactory()
                let driver = factory.createDriver()
                driver.putString(key: "Test", value: "TES1234")
                
                print("VAL : \(driver.getStringOrNull(key: "Test"))")
                // let sample = Sample()
                // sample.test(parameter: 22)
                
                // let val = sample.getTest()
                // print("VAL \(val?.intValue)")
                */
                
                let keyValueStorage = KeyValueStorageFactory().createDriver()
                keyValueStorage.putString(key: "key_123", value: "1234")
                let value = keyValueStorage.getStringOrNull(key: "key_123")
                print("VALUE \(value)")
                
                let sampleEnum = SampleEnum.all
                switch sampleEnum {
                case .all: break
                case .favorites: break
                default:
                    break
                }
                
                let genericBaseModel = GenericBaseModel<Test>(data: nil, exception: nil, empty: false, loading: false)
                
                
            }, label: {
                Text("Storage")
            })
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

class Test {
    
}

class SampleImplemented: SampleInterface {
    func foo() {
        
    }
    
}
