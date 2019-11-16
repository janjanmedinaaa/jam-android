# JAM Android Starter
A Personal Base Project for my Kotlin Android Projects that includes ready to use libraries.

## Setup Starter Pack:
- `JAMActivity` BaseActivity
- `Jsonable` Interface
- Toast Display
- String Extensions
- Shared Preferences Extensions
- Transitioning Check

## External Library Included:
- Gson

## Other Library Setup

### Data Binding
- Add dataBinding on **app-level** build.gradle

```
dataBinding {
    enabled = true
}
```

- Install `kotlin-kapt` plugin

```
apply plugin: 'kotlin-kapt'
```