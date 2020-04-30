## MineTrades Server App

This is a server side application for the [MineTrades site](https://github.com/NightKosh/MineTrades).
It provides you a rest Get endpoint to request all required data about trades on your server. This application designed to be used with [QuickShop](https://github.com/Ghost-chu/QuickShop-Reremake) and [LuckPerms](https://github.com/Ghost-chu/QuickShop-Reremake) spigot plugins, or, to be more correct, with their databases.  

## Endpoint

This application provides you a single get endpoint:
```
    /search?item=ITEM_ID&enchantment=ENCHANTMENT_ID
```
"item" is a required parameter, but "enchantment" is optional and should be used only for enchanted books(in other cases it will be ignored) 

## Branches

At the moment there are a few branches in this repository. As you may suggest by their names, the main difference between them is the amount and types of the databases. The "master" branch supports "single"(that's means that QuickShop and LuckPerms tables stored in the same database) postgres database.

## Configuration

To make it easier for you almost all important things can be configured in "application.yml" file in "configs" section. For sure some of them, such as database connection parameters should be changed by you, but other params are optional and has default values. 
Alternatively, instead of any modifications in the sources, you can provide those params at the application start up. 
Here is the list of all available parameters:
* DB_TYPE - type of the database(default - postgresql). Application in the master branch designed for postgres database, so some other databases may require some additional modification
* DB_HOST - database host(default - localhost:5432)
* DB_NAME - database name(default - postgres)
* DB_USER - database user name(default - postgres)
* DB_PASSWORD - database password(default - Qwerty)
* SHOW_PRICE - this option allows you disable to show trades prices(default - false)
* UNKNOWN_PLAYER_NAME - text which will be used in case of no data about player in your database(default - Unknown)

## Deploy

To build application run next command(be sure you have Gradle 5 and Java 8):
```
    gradle bootJar
```

Alternatively you can use one of the builds from [Releases](https://github.com/NightKosh/MineTradesServer/releases) section on the github page of the repository. 

To run application run next command(be sure you have Java 8):
```
    java -jar APPLICATION_JAR_NAME.jar
```

Also, as already said, you can provide all configuration params at the application start up. All of them are optional(in case of lack of some the default parameters from "application.yml" will be used). Just add next text at the end of previous command:
```
    --PARAM_NAME=VALUE 
```

## P.S.

This application created for my own purpose, so it is provided to you as is. Feel free to use it in any way you want, but I'm not guaranty you any support in the future.
