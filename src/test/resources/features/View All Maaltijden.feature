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

   Scenario: Informatie wanneer de maaltijd vegetarisch is wordt weergegeven
   Given lijst van maaltijden
   When “Jan” op het menu kijkt
   Then ziet hij dat de maaltijd vegetarisch is

  Scenario: Informatie wanneer de maaltijd glutenvrij is wordt weergegeven
  Given lijst van maaltijden
  When “Jan” het menu opent
  Then ziet hij dat de maaltijd glutenvrij is

  Rule: De prijs moet altijd getoond worden
    Scenario: informatie waar de prijs wordt weergegeven
      Given dat er maaltijden zijn met prijs informatie
      When “Jan” op het menu kijkt
      Then zou “Jan” de maaltijden zien met hun prijs
  Rule: Maaltijden worden gegroepeerd per categorie

    Scenario: informatie waar de categorie wordt weergegeven
      Given dat er maaltijden zijn met categorie informatie
        | Maaltijd                   | categorie             |
        | Broodje martino            | broodjes              |
        | Lasagne                    | pasta                 |
        |tomatensoep                 | soepen                |
      When “Jan” op het menu kijkt
      Then zou “Jan” de maaltijden zien met hun categorie


