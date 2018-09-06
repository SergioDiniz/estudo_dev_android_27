
# Anotações
### Instalação
* Instalar Android Studo em modo Avançado
* Instalar Intel HAXM para melhorar o Emulador
* Pasta do SDK não pode ter espaços nem caracter especial
### Configurações do SDK Manager
 * [ ]  Para cada versão do Android
		* Instalar Android Platform
		* Instalar Sources for Android 
		* Instalar o "Google APIs Intel x86 Atom System Image" (Quando possui Intel HAXM)
		- Ou Google APIs ARM EABI (Quando não possui Intel HAXM)
 * [ ] Instalar Android SDK Build-Tools (v. mais recente) - Tools
 * [ ] Instalar Google Play Services - Tools
 * [ ] Instalar Google USB Driver - Tools (Windows)
 * [ ] Instalar ConstraintLayout for Android (v. mais recente) - Tools
 * [ ] Instalar Solver for ConstraintLayout (v. mais recente) - Tools
 * [ ] Instalar Android Support Repository - Tools
 
 ### Suluções de Problemas
 * Visualização do Design no AS não funciona:
 	* No Arquivo styles.xml aditar: <style name="AppTheme" parent="Base.Theme.AppCompat.Light.DarkActionBar">
	* No build.gradle(Module: app) editar: 
		* compileSdkVersion 26
		* targetSdkVersion 26
		* implementation 'com.android.support:appcompat-v7:26.1.0'
		* implementation 'com.android.support:design:26.1.0'
	
