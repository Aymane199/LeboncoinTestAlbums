# LeboncoinTestAlbums
Technical test to be performed, a native Android application displaying the following list of albums : https://static.leboncoin.fr/img/shared/technical-test.json

# TODO List
- [x] Mvvm_architecture_implemetation
- [x] Model implementation
- [X] View implementation (basic ui)
- [x] MovelView implementation
- [x] Improve UI
- [ ] Local database
- [ ] Splash screen

# Architecture overview
![](https://i.ibb.co/4VHfnXV/Capture.jpg)

The app is a stateless client: all operations are performed by calling api endpoints over the network.
Local data is in effect immutable, the client just downloads versions of data as needed.
The data is stored as Observables objects in ViewModel class. We interact with the api using REST client retrofit which is implemented in repository class, repository class send requests and according to the response it updates the itself and ModelView objects.
Each View have its own ViewModel, the ViewModel prepare data to the View, the View observe this data, every change noticied the View execute a routine (in our case update the recycle view adapter) 

### Model folder
- **entity** *(contains entities used)*
- **remote** *(contains service & retrofit interfaces)*
- **repository** *(contains implementation of retrofit interface - send requests to Api & update observable objects)*

### View folder *(contains all fragments of the app)*
- fragement *(the fragement class)*
- **adapter** (if needed) *(contains Adapters)*
- **listener** (if needed) *(contains listeners)*

### ViewModel folder *(contains all ViewModels of the app)*
- viewModelFragment *(the ViewModel class)*

# Preview
![](https://i.ibb.co/yfGGD59/interface.jpg)

# Dependencies
- **navigation component** : *When developing applications with multiple Fragement, we tend to do a lot of fragmented transactions to navigate between them. Writing these fragmented transactions and managing the back stack is annoying. not implementing it correctly IllegalStateException appear :). Android Jetpack's Navigation component helps you implement navigation easly and with a visual demonstration*
- **viewmode**l : *ViewModel is a class that is responsible for preparing and managing the data for the fragement,ViewModel will not be destroyed if its owner is destroyed for a configuration change (e.g. rotation). The new instance of the owner will just re-connected to the existing ViewModel by using viewModelProvider.*
- **livedata** : *LiveData is an observable data holder class.LiveData is ,it respects the lifecycle of other app fragments, so it update only active faragments*
- **retrofit** : *Retrofit save lot of development time, And also can keep the code in developer friendly by using interfaces*
- **converter-gson** : *Gson is a Java library that can be used to convert Java Objects into their JSON representation, or the opposite. converter-gson is a converter which uses Gson for serialization to and from JSON.*
- **picasso** : *Picasso download the image in another thread and it manages for you: he placeholder in the meantime the image is still downloading, 
resizing, 
cropping/centering/scaling, 
caching ( you don't have to download the image every time), 
it even does "image fade in", which is popular/normal now [source](https://stackoverflow.com/a/22331132/11539336).*



