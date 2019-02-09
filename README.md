# Cwiczenie 1

.gitignore:

    *
    !*/
    !/app/src/main/**
    !.gitignore
    README.md

    #*.iml
    #.gradle
    #/local.properties
    #/.idea/libraries
    #/.idea/modules.xml
    #/.idea/workspace.xml
    #.DS_Store
    #/build
    #/captures
    #.externalNativeBuild

gdy mamy problem z wyswietlaniem preview:
to w `res/values/styles.xml` :
   ```xml 
    <style name="AppTheme" parent="Base.Theme.AppCompat.Light.DarkActionBar">
   ```

