# ConfigDSL

## Project Overview

**ConfigDSL** est une bibliothèque Scala qui permet de gérer les configurations avec un DSL (Domain-Specific Language) intuitif et fortement typé. Ce DSL a été conçu pour simplifier la définition, la manipulation et l'accès aux configurations dans des projets fonctionnels.

Les configurations sont une part essentielle de nombreux systèmes logiciels. Avec **ConfigDSL**, vous pouvez :
- Définir des clés de configuration fortement typées.
- Construire des configurations immuables avec une syntaxe fluide.
- Accéder aux valeurs avec une sécurité des types, évitant ainsi les erreurs communes liées à des types incohérents.

Le DSL favorise les bonnes pratiques de programmation fonctionnelle tout en étant extensible pour s'adapter à des besoins spécifiques.

---

## Design Decisions

### Motivation

La conception de **ConfigDSL** repose sur les principes suivants :
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
