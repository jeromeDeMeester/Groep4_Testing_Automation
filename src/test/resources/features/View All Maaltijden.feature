Feature: View menu
  As a potential customer
  I want to be able to see all available meals
  So that I can order the meals I want to eat
# Personas
# Jan – Student TI
Rule: Toon alle maaltijden die op het menu staan
  Scenario: Alle maaltijden worden getoond
    Given dat er maaltijden op het menu staan
    When “Jan” op het menu kijkt
    Then worden alle maaltijden getoond die op het menu staan

  Scenario: Er worden geen maaltijden getoond want er staan geen maaltijden op het menu
    Given er geen maaltijden op het menu staan
    When “Jan” op het menu kijkt
    Then krijgt “Jan” een melding dat er momenteel nog geen broodjes op het menu staan


Rule: Informatie over allergieën en al dan niet vegetarisch moet getoond worden

  Scenario: Informatie over sporen wordt weergegeven
  Given Dat een “broodje brie” “walnoten” bevat
  When “Jan” op het menu kijkt
  Then ziet hij dat de maaltijd sporen van walnoten bevat

#TODO Meerdere dezelfde scenarios?

   Scenario: Informatie wanneer de maaltijd vegetarisch is wordt weergegeven
   Given lijst van maaltijden
   When “Jan” op het menu kijkt
   Then ziet hij dat de maaltijd vegetarisch is
#
  Scenario: Informatie wanneer de maaltijd glutenvrij is wordt weergegeven
  Given lijst van maaltijden
  When “Jan” het menu opent
  Then ziet hij dat de maaltijd glutenvrij is
#
#  Scenario Outline: Extra Informatie over de maaltijd wordt weergegeven
#  Gegeven lijst van maaltijden
#  Wanneer “Jan” het maaltijd “<maaltijd>” selecteert
#  Dan ziet hij dat de maaltijd “<info>” is
#    Examples:
#      | maaltijd             | info              |
#      | broodje brie            | sporen van walnoten |
#      | broodje veggylicious        | vegetarisch         |
#      | broodje spelt            | glutenvrij          |
#
#  Scenario: Extra Informatie over de maaltijden wordt weergegeven
#    Given dat er maaltijden zijn met extra informatie
#      | Maaltijd                                 | Allergieën                              | Vegetarisch?    |
#      | Broodje brie met walnoten   | Sporen van noten, Gluten  |                          |
#      | Broodje Veggylicious         | Gluten                                | Vegetarisch      |
#      | Frikandel                            |                                               |                          |
#    When "Jan" het menu bekijkt
#    Then zou "Jan" de maaltijden te zien moeten krijgen met de extra informatie
#

  Rule: De prijs moet altijd getoond worden
    Scenario: informatie waar de prijs wordt weergegeven
      Given dat er maaltijden zijn met prijs informatie
        | Maaltijd                          | prijs         |
        | Broodje martino                   | 2 euro        |
        | Lasagne                           | 4 euro 30 cent |

      When “Jan” op het menu kijkt
      Then zou “Jan” de maaltijden zien met hun prijs
  Rule: Maaltijden worden gegroepeerd per categorie

    Scenario: informatie waar de categorie wordt weergegeven
      Given dat er maaltijden zijn met prijs informatie
        | Maaltijd                   | categorie             |
        | Broodje martino            | broodjes              |
        | Lasagne                    | pasta                 |
        |tomatensoep                 | soepen                |

      When "Jan" het menu bekijkt
      Then zou "Jan" de maaltijden zien met hun categorie


