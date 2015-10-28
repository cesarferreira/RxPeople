# RxPeople
> A Library for generating random user data. Like Lorem Ipsum, but for people.

<p align="center">
<img src="https://raw.github.com/cesarferreira/rxpeople/master/extras/images/contact.gif?raw=true" width="100%" />
</p>

## Usage

Simple Usage:
```java
RxPeople.with(context)
         .amount(50)
         .intoObservable()
         .subscribe(users -> {
            // todo: what you please
         });
```


Advanced: *Get 50 american women:*
```java
RxPeople.with(context)
         .amount(50)
         .nationality(Nationality.US)
         .gender(Gender.FEMALE)
         .intoObservable()
         .subscribe(users -> {
            // todo: what you please
         });
```


## Install

Add the dependency in the form:
```groovy
dependencies {
  compile 'com.cesarferreira.rxpeople:rxpeople:0.1.0'
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
