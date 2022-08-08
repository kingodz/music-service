# Music Service application

### Music Service 

e want you to create a REST API for providing clients with information about a specific music artist. The information is collected from 4 different  sources: MusicBrainz, Wikidata, Wikipedia and Cover Art Archive.


MusicBrainz offers an API returning detailed information about music artists e.g. name, birthday, birth country etc.


WikiData acts as central storage for the structured data of its Wikimedia sister projects including Wikipedia, Wikivoyage, Wiktionary, Wikisource,  and others.


Wikipedia offers an API returning more descriptive information about many different things, one of them are music artists.


Cover Art Archive is a side-project to MusicBrainz which offers an API finding cover art for albums and singles for a specific music artist.


### Public API

The API takes an MBID (MusicBrainz Identifier) and return a result containing the following:
A description of the artist fetched from Wikipedia resource.

A list of all albums the artist has released and links to its corresponding album cover art. 


###  REST API
Get profile for an artist

GET /musify/music-artist/details/{mbid}

### Build and Run
install maven and jdk17
in console: mvn clean install
From the root of the project run: mvn spring-boot:run


### sample MB-IDs and curl examples

M Jackson, Coldplay, Snoop Dogg

curl -X GET "http://localhost:8080/musify/music-artist/details/f27ec8db-af05-4f36-916e-3d57f91ecf5e?"
curl -X GET "http://localhost:8080/musify/music-artist/details/cc197bad-dc9c-440d-a5b5-d52ba2e14234"
curl -X GET "http://localhost:8080/musify/music-artist/details/f90e8b26-9e52-4669-a5c9-e28529c47894"

### Inner workings of service

First the rest controller gets an MB-ID on
GET /musify/music-artist/details/{mbid}

Then artistService calls MusicBrainz to get an artist Profile 
In the profile there is a sitelink url to wikipedia for the artist.
WikipediaService uses that sitelink url to get the Wikipedia Summary

The musicBrainz Profile also has ReleaseGroups IDs.
These IDs are used to call the coverArt Server to get the cover art image urls.

The information is merged and returned to consumer in the InfoResponse class.

See ArtistService class.

### History
Started with spring boot initializer


libraries used: 
https://github.com/Wikidata/Wikidata-Toolkit

Tools used:
https://www.jsonschema2pojo.org/


todo:
due to time constraint there is a lot to do regarding 
response times, resilience, exception handling.
remove resttemplate
use webflux
Fetch the biggest API calls in parallel (the cover art) by using webflux
unit tests
logs
error handling
metrics
authentication 
authorization
integration test
