import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    let db = MembersRepository(databaseDriverFactory: DatabaseDriverFactory())
    let coinstatsAPI = CoinstatsAPI()
    
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
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
