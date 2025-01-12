## Как начать
1. Изменить `group`, `mod_name`, `mod_author`, `mod_id` в `gradle.properties` 
2. Изменить `rootProject.name`  в `settings.gradle`.
3. Изменить `MOD_ID`, `MOD_NAME` в `:Common.Constants` 
4. Изменить `modId`, `displayName` в `:Forge/resources/META-INF/mods.toml`
5. Изменить `id`, `name` в `resources/fabric.mod.json`
6. Запустить `Your Project > Common > Tasks > vanilla gradle > decompile` для декомпила кубов
7. Запустить `Your Project > Forge > Tasks > forgegradle runs > genIntellijRuns` для конфигурации forge
