![](images/banner.png)
Java API for the [JokeAPI](https://jokeapi.dev/) server.

# Getting Started

If you're using Maven
```xml
<dependency>
    <groupId>com.simtechdata</groupId>
    <artifactId>JokeAPI</artifactId>
    <version>1.0.0</version>
</dependency>
```

Or, if using Gradle to build, add this to your Gradle build file

```groovy
compile group: 'com.simtechdata', name: 'JokeAPI', version: 1.0.0
```

You can even use it from a Groovy script!

```groovy
@Grapes(
  @Grab(group='com.simtechdata', module='JokeAPI', version=1.0.0)
)
```

### Modular Apps
If your app is modular, then add this to your ```module-info.java``` file
```Java
requires com.simtechdata.jokeapi;
```

# Quick Start

You can read about all of the features of the  [JokeAPI here](https://jokeapi.dev/). This library gives you a native Java interface to access all of the Joke API's features and abilities.

It's as simple as this to get a joke
```Java
import com.simtechdata.jokes.Jokes;
import static com.simtechdata.jokes.enums.Category.*;

public static void readAJoke() {
    Jokes jokes = new Jokes.Builder().addCategory(ANY_CATEGORY).build();
    System.out.println(jokes.getAny());
}
```
### Builder Style

This API uses Builder style, making it easy to pick and chose which features of the API you want to access.

The Builder has these options

```Java
addCategory(Category)
addBlackList(Flag)
setFormat(Format)
setLanguage(Language)
type(Type)
possibleLanguage(PossibleLanguage)
safeMode()
idRange(int, int)
id(int)
contaions(String)
build()
```

The options that will be utilized most often are `addCategory`, `addBlackList` and possibly `safeMode`.

Safe mode is the APIs best effort at getting clean, safe for everyone kinds of jokes. It makes no guarantees in that regard, but in my testing, it did alright.

Whatever your need is, you always start with instantiating the Jokes class using its Builder.
```Java
Jokes jokes = new Jokes.Builder()
              .addCategory(Category.PUN, Category.PROGRAMMING)
              .addBlackList(Flag.EXPLICIT, Flag.RACIST)
              .build();
```
Once you have the object defined the way you want it, you can then get whatever you need from it.

So lets say you want to get the total number of jokes available on the server
```Java
System.out.println("Total Jokes: " + jokes.getTotalJokes());
```

Or if you just want to get a String of a random joke from the categories you selected
```Java
System.out.println(jokes.getAny());
```

If you just wanted to get a two part joke (those with a setup and delivery) or just a one part joke, you can do that with these methods.

```Java
jokes.getTwoPart();
jokes.getOnePart();
```
Those methods give you a single String with the setup and delivery in that one String or just the joke in the case of the one part method.

If you want to get the entire Joke object so that you can access the Strings directly, you would do this:

```Java
Jokes jokes = new Jokes.Builder()
              .type(Type.TWOPART)
              .addCategory(Category.ANY_CATEGORY)
              .addBlackList(Flag.EXPLICIT)
              .build();
Joke joke = jokes.getJoke();
String setup = joke.getSetup();
String delivery = joke.getDelivery();
```
There are other properties of the joke instance that you can access, and code completion in your IDE can show you what those are.

What if you wanted to get a joke that has the word `milk` in it
```Java
Jokes jokes = new Jokes.Builder()
              .addCategory(Category.ANY_CATEGORY)
              .contains("milk")
              .build();
System.out.println(jokes.getAny());
```
You can also get several jokes at once, up to 10
```Java
Jokes jokes = new Jokes.Builder()
              .addCategory(Category.ANY_CATEGORY)
              .contains("milk")
              .build();
StringBuilder sb = new StringBuilder();
Multi multi = jokes.getMulti(10);
int count = 1;
for (Joke joke : multi.jokes) {
    sb.append(count).append(") ");
    if (joke.isTwoPart()) {
        sb.append(joke.getSetup()).append(" ").append(joke.getDelivery()).append("\n");
    }
    else {
        sb.append(joke.getJoke()).append("\n");
    }
    sb.append("\n");
    count++;
}
System.out.println(sb);
```
Jokes have an id number associated with them, starting at number 0 and going up to the `getTotalJokes()` value minus 1. So if you wanted to download a range of jokes, you could do so like this
```Java
Jokes jokes = new Jokes.Builder()
              .addCategory(Category.ANY_CATEGORY)
              .build();
for (int x=20; x < 40; x++) {
    System.out.println(jokes.getJokeId(x));
}
```

### Checking for errors
Sometimes things happen and they don't always go the way you'd like. So we can check the return of our joke for an error and get more information about it.
```Java
String joke = jokes.getAny();
if (joke.contains("error")) {
    JokeError error = jokes.getError();
    System.out.println(error.getMessage());
}
```

### Release Notes
* 1.0.0 - Initial Release
