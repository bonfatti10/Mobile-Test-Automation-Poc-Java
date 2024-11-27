#!/bin/sh

#Colors
Green='\033[0;32m'
Yellow='\033[0;33m'
NC='\033[0m'


echo "${Yellow}#######################################################"
echo "## Baixe o Intellij COMMUNITY EDITION ou INTELLIJ CE ##"
echo "#######################################################${NC}"
open https://www.jetbrains.com/idea/download/other.html

##check versions
version() {
  echo "$@" | awk -F. '{ printf("%d%03d%03d%03d\n", $1,$2,$3,$4); }';
}

#verifica brew
if which brew >/dev/null; then
  echo "${Green}brew instalado${NC}"
else
  echo "${Yellow}instalando brew${NC}"
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
fi

#verifica node
nodeVersionRaw=$(node --version)
nodeVersion="${nodeVersionRaw:1}"

if [ "$(version "$nodeVersion")" -ge "$(version "21.0.0")" ]; then
  echo "${Green}Node Atualizado! Versão $nodeVersion${NC}"
else
  echo "${Yellow}Node desatualizado ou não instalado! Instalando ultima versão...${NC}"
  brew uninstall node
  brew install node

  echo "${Green}Node instalado com sucesso, versão: $(node --version)${NC}"
fi

# verificando versão appium
echo "Verificando appium"
appiumVersion=$(appium -v)

if [ "$(version "$appiumVersion")" -ge "$(version "2.5.1")" ]; then
  echo "${Green}Appium Atualizado! Versão $appiumVersion${NC}"
else
  echo "${Yellow}Appium desatualizado ou não instalado! Instalando versão 2.5.1 ou superior...${NC}"
  brew uninstall appium
  brew install appium

  echo "${Green}Appium instalado com sucesso, versão: $(appium -v)${NC}"
fi

appiumDrivers="$(appium driver list --installed 2>&1)"

# verificando XCUITest
if [[ "$appiumDrivers" == *"xcuitest"* ]]; then
  echo "${Green}Driver iOS instalado!${NC}"
else
  echo "${Yellow}Baixando driver iOS${NC}"
  npm install appium-xcuitest-driver
  appium driver install xcuitest
fi

# verificando android automator
if [[ "$appiumDrivers" == *"uiautomator2"* ]]; then
  echo "${Green}Driver android instalado!${NC}"
else
  echo "${Yellow}Baixando driver android${NC}"
  npm install appium-uiautomator2-driver
  appium driver install uiautomator2
  echo "Driver android instalado!"
fi

echo "${Green}Ambiente Appium Configurado${NC}"

# Verificando Maven
if which mvn >/dev/null; then
  echo "${Green}Maven instalado${NC}"
else
  echo "${Yellow}instalando Maven${NC}"
  brew install maven
fi
