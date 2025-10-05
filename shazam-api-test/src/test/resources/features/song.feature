@song
Feature: Obtener detalles de una canción por ID y validar campos específicos

  Background:
    Given que el usuario quiere obtener detalles de una canción

  @getSongDetails
  Scenario: Consultar canción y validar título y artista específicos
    When consulta la canción con el id "262638322"
    Then la respuesta debe ser exitosa 200
    And el valor de "data[0].attributes.name" debe ser "De Música Ligera"
    And el valor de "data[0].attributes.artistName" debe ser "Soda Stereo"
    And el valor de "data[0].attributes.albumName" debe ser "Me Verás Volver (Hits & Más)"

  @postSongFromAudio
  Scenario: Detectar una canción desde un archivo de audio válido
    When el usuario detecta la canción usando el archivo "src/test/resources/audio/MusicaLigera.mp3"
    Then la respuesta debe ser exitosa 204