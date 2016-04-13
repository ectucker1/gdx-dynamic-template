# gdx-dynamic-template
A Groovy template for libGDX projects.

This project contains code and Gradle build setups I tend to duplicate between libGDX projects. This is mostly intended for my own use, and uses very specific libraries and architecture. Some of you may find it too restricting, but others may agree with my descisions.

## Features
- Preconfigured unit testing setup with [Spock](https://github.com/spockframework/spock)
- Prebuilt state machine
- Prebuilt menu states
- Generic [Ashley](https://github.com/libgdx/ashley/wiki) components & systems
- TweenAccessors for components, music, and vectors
- Dynamic properties on GDX class for tweens, states, json, and yaml
- CC0 License!

## Libraries Included
Libraries for production
- [Groovy](http://www.groovy-lang.org/)
- [LibGDX](https://libgdx.badlogicgames.com/) (Duh?)
- [Ashley ECS](https://github.com/libgdx/ashley/wiki)
- [TweenEngine](https://github.com/dorkbox/TweenEngine)
- [libgdx-utils](https://bitbucket.org/dermetfan/libgdx-utils/wiki/Home)
- [SnakeYAML](https://bitbucket.org/asomov/snakeyaml)

Libraries for testing
- [Spcok](https://github.com/spockframework/spock)
- [JUnit 4](http://junit.org/junit4/)
- [cglib](https://github.com/cglib/cglib)
- [objenesis](http://objenesis.org/)

Exact library versions can be found in the project build.gradle file.

## License
The whole template is licensed under CC0, as there's really nothing here you couldn't replicate in an hour. Assets included are also CC0 licensed by their respective creators.
