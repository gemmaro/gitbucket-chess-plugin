# gitbucket-chess-plugin

A GitBucket plugin for rendering PGN chess file with `.pgn` extension.

## Screenshot

TODO

## Install

1. Download *.jar from Releases.
2. Deploy it to `GITBUCKET_HOME/plugins`.
3. Restart GitBucket or reload plugins.

## Build from source

```sbt
sbt clean package
```

The built package is located at
`target/scala-*/gitbucket-chess-plugin_2.13-{plugin-version}.jar`.

```sbt
sbt assembly
```

This makes the assembly package
`target/scala-2.13/gitbucket-chess-plugin-{plugin-version}.jar`
for deployment.

## Version

Plugin version|GitBucket version
:---|:---
1.0.x |4.36.x -

## Acknowledgement

* This plugin is based on [onukura's `gitbucket-smiles-plugin`](https://github.com/onukura/gitbucket-smiles-plugin).
* This plugin uses [mliebelt' PgnViewerJS](https://github.com/mliebelt/PgnViewerJS).
