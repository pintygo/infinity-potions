## Зависимости и полезная информация
Java version = 17
Gradle Version = 8.8

## Действия при создании нового мода из темплейта
1. Изменить `group`, `mod_name`, `mod_author`, `mod_id` в `gradle.properties` 
2. Изменить `rootProject.name`  в `settings.gradle`.
3. Изменить `MOD_ID`, `MOD_NAME` в `:Common.Constants` 
4. Изменить `modId`, `displayName` в `:Forge/resources/META-INF/mods.toml`
5. Изменить `id`, `name` в `resources/fabric.mod.json`
6. Запустить `Project > Common > Tasks > vanilla gradle > decompile` для декомпила кубов
7. Запустить `Project > Forge > Tasks > forgegradle runs > genIntellijRuns` для конфигурации forge


## Запуск клиента из IJ IDEA
### Forge
`Project > Forge > Tasks > forgegradle runs > Client`

### Fabric
`Project > Fabric > Tasks > fabric > runClient`

## Building version
### Forge
`Project > Forge > Tasks > build > build`

Output directory `Fabric/build/libs`
### Fabric
`Project > Fabric > Tasks > build > build`
Output directory `Forge/build/libs`