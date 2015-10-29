# RxPeople
> A Library with fluent API for generating random user data. Like Lorem Ipsum, but for people.

<p align="center">
<img src="https://raw.github.com/cesarferreira/rxpeople/master/extras/images/contact.gif?raw=true" width="100%" />
</p>

## Usage


Getting 100 random women and men from random countries:
```java
RxPeople.with(context)
         .amount(100)
         .intoObservable()
         .subscribe(users -> {
            // todo: what you please
         });
```

Being specific: **Getting 50 Brazilian women:**

```java
RxPeople.with(context)
         .amount(50)
         .nationality(Nationality.BR)
         .gender(Gender.FEMALE)
         .intoObservable()
         .subscribe(users -> {
            // todo: what you please
         });
```


### Useful info
- It's **really important** to set both `.subscribeOn()` and `.observeOn()` it's the only way to guarantee the thread which the request is gonna run at (if you don't know why I'm asking this read my blog post [Party tricks with Rxjava](https://medium.com/swlh/party-tricks-with-rxjava-rxandroid-retrolambda-1b06ed7cd29c));
- Want to convert my *FakeUser* class into your own *UserClass*? use a *flatMap* to transform it before subscribing to the *Observer*, easypeasy;
- An **example.json** of a complete **User** can be found [here](https://raw.github.com/cesarferreira/rxpeople/master/extras/sample_response.json);
- Don't forget to check the [Sample project]( https://github.com/cesarferreira/RxPeople/blob/master/sample/src/main/java/github/cesarferreira/rxpeople/sample/UsersAdapterFragment.java).

## Install

Add the dependency in the form:
```groovy
dependencies {
  compile 'com.cesarferreira.rxpeople:rxpeople:0.2.1'
}
```

## Thanks to
- API from: https://randomuser.me/
- Image from: https://dribbble.com/ericazares


## Contributing

1. Fork it ( https://github.com/cesarferreira/RxPeople/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request
