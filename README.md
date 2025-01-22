# dsl_project

## Project Overview

- **Contexte**: Au sein d'une entreprise de développement logiciel
- **Probleme**: Les développeurs manipulent souvent des fichiers de configuration sous formats  JSON, YAML, ou HOCON. qui sont parfois difficiles à valider, sujets à erreurs, et peu flexibles et complexes.
- **Pourquoi un DSL ?** il permet de définir des configurations directement dans le code, avec validation au moment de la compilation et une syntaxe fluide.

Ce projet Scala permet de gérer les configurations d'applications avec un DSL (Domain-Specific Language) intuitif et fortement typé. Ce DSL a été conçu pour simplifier la définition, la manipulation et l'accès aux configurations dans des projets fonctionnels.

Ce DSL permet de :
- Définir des clés de configuration fortement typées.
- Construire des configurations immuables avec une syntaxe fluide.
- Accéder aux valeurs avec une sécurité des types, évitant ainsi les erreurs communes liées à des types incohérents.

---

## Design Decisions

### Motivation

La conception de ce DSL repose sur les principes suivants :
1. **Sécurité des types** : Chaque clé de configuration est associée à un type, garantissant que seules des valeurs de ce type peuvent être associées ou récupérées.
2. **Immutabilité** : Les configurations sont immuables, respectant les paradigmes de la programmation fonctionnelle.
3. **Simplicité** : Fournir une syntaxe intuitive et fluide pour faciliter la création et la manipulation des configurations.
4. **Extensibilité** : Une architecture modulaire permettant d’ajouter des fonctionnalités supplémentaires.

### Décisions techniques

- **Immutabilité** : Utilisation d’une structure de données immuable (Map) pour stocker les configurations.
- **DSL simple** : L'objet `ConfigDSL` encapsule les principales abstractions (`ConfigKey`, `ConfigValue`, `Config`) et fournit des méthodes claires (`define`, `config`).
- **Gestion des types** : Pour renforcer la sécurité des types, les génériques Scala (`[A]`) sont utilisés. Une future amélioration pourrait intégrer des *TypeTags* pour une validation stricte au runtime.

---

## Usage Examples

Voici un exemple montrant comment utiliser **ConfigDSL** dans un projet Scala.

### Définir des clés et construire une configuration

```scala
import ConfigDSL._

object Main extends App {
  def run(): Unit = {
    // Définir des clés typées
    val hostKey = define[String]("host")
    val portKey = define[Int]("port")

    // Créer une configuration
    val appConfig = config { config =>
      config
        .add(hostKey, "localhost")
        .add(portKey, 8080)
    }

    // Lire les valeurs
    println(appConfig.get(hostKey)) // Some("localhost")
    println(appConfig.get(portKey)) // Some(8080)

    // Mettre à jour une valeur
    val updatedConfig = appConfig.update(portKey, _ + 1)
    println(updatedConfig.get(portKey)) // Some(8081)
  }

  run()
}

```
---

## Instructions

### Prérequis
- Scala 3
- SBT (Scala Build Tool)

### Cloner le projet
Clonez le projet en exécutant cette  instruction dans l'nvite de commande
"git clone https://github.com/melissalhb/dsl_project.git
cd dsl_project"

### Builder le projet
Pour compiler le projet : **sbt compile** dans l'nvite de commande

### Tester le projet
Pour exécuter les tests : **sbt test** dans l'nvite de commande

### Lancer un exemple
Pour lancer un exemple d'utilisation : **sbt run** dans l'nvite de commande


## Structure du projet
Le projet est organisé en plusieurs sous-composants pour une meilleure séparation des responsabilités :
- **Core DSL :** Implémente le cœur du DSL et les opérations principales.
- **Examples :** Contient des exemples concrets montrant comment utiliser le DSL dans des scénarios réalistes.
- **Tests :** Fournit des tests unitaires pour valider les comportements du DSL et garantir la qualité du code.


---

### Description des principaux éléments

#### **1. Répertoires générés automatiquement**
- **`.bsp/`** : Gère l'intégration avec le protocole Build Server Protocol (BSP) pour les outils compatibles.
- **`.metals/`** : Contient des fichiers nécessaires pour Metals, un outil d'analyse et de compilation Scala.
- **`.vscode/`** : Paramètres spécifiques pour Visual Studio Code, facilitant la configuration de l'IDE.

#### **2. Répertoires de projet**
- **`project/`** :
  - **`build.properties`** : Définit la version de SBT utilisée pour ce projet.
  - **`target/`** : Répertoire temporaire pour les fichiers générés lors des builds.
  - **`.history3`** : Fichier d'historique des commandes SBT exécutées.

#### **3. Répertoire `src/`**
- **`src/main/scala/`** :
  - **`Config.scala`** : Contient l'implémentation principale du DSL (par exemple, `Config`, `ConfigKey`, `ConfigValue`).
  - **`Main.scala`** : Point d'entrée pour démontrer les fonctionnalités du DSL.
- **`src/test/scala/`** :
  - **`ConfigSpec.scala`** : Suite de tests unitaires pour valider les fonctionnalités principales du DSL.
  - **`testUseCase.scala`** : Tests supplémentaires pour des scénarios spécifiques.

#### **4. Répertoire `Examples/`**
- Contient des worksheets Scala interactifs pour tester et démontrer les fonctionnalités du DSL :
  - **`worksheet1.sc`** : Exemple simple montrant la création et l'utilisation de clés.
  - **`worksheet2.sc`** : Ajout, mise à jour, et suppression de clés.
  - **`worksheet3.sc`** : Cas d'utilisation conditionnels.
  - **`worksheet4.sc`** : Scénarios avancés et tests de performance.

#### **5. Fichiers de configuration**
- **`build.sbt`** : Fichier principal pour la gestion des dépendances et la configuration du projet.
- **`.gitignore`** : Définit les fichiers à exclure du contrôle de version (par exemple, `target/`, `.metals/`).

#### **6. Documentation**
- **`README.md`** : Contient la documentation du projet, y compris une introduction, des instructions d'installation, des exemples, et la structure du projet.

---

## Améliorations futures
- **Validation avancée :** Ajouter des mécanismes de validation pour s’assurer que certaines clés respectent des contraintes spécifiques (exemple : un numéro de port entre 0 et 65535).
- **Sérialisation/Désérialisation :** Intégrer la prise en charge des formats standard (JSON, YAML) pour importer/exporter des configurations facilement.
- **Interopérabilité :** Fournir des adaptateurs pour interagir avec des bibliothèques tierces de gestion de configuration.
- **Performances :** Optimiser les opérations sur de grandes configurations en utilisant des structures de données persistantes.

## Licence
Ce projet est sous licence MIT. Vous êtes libre de l'utiliser, le modifier et le redistribuer avec attribution.

## Auteurs
- **Mélissa**
- **Rayan**
- **Aymar**
    
