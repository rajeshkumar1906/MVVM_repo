package com.raaz.domain.model.openlib


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DocX(
    @SerializedName("already_read_count")
    val alreadyReadCount: Int = 0,
    @SerializedName("author_alternative_name")
    val authorAlternativeName: List<String> = listOf(),
    @SerializedName("author_facet")
    val authorFacet: List<String> = listOf(),
    @SerializedName("author_key")
    val authorKey: List<String> = listOf(),
    @SerializedName("author_name")
    val authorName: List<String> = listOf(),
    @SerializedName("contributor")
    val contributor: List<String> = listOf(),
    @SerializedName("cover_edition_key")
    val coverEditionKey: String = "",
    @SerializedName("cover_i")
    val coverI: Int = 0,
    @SerializedName("currently_reading_count")
    val currentlyReadingCount: Int = 0,
    @SerializedName("ddc")
    val ddc: List<String> = listOf(),
    @SerializedName("ddc_sort")
    val ddcSort: String = "",
    @SerializedName("ebook_access")
    val ebookAccess: String = "",
    @SerializedName("ebook_count_i")
    val ebookCountI: Int = 0,
    @SerializedName("edition_count")
    val editionCount: Int = 0,
    @SerializedName("edition_key")
    val editionKey: List<String> = listOf(),
    @SerializedName("first_publish_year")
    val firstPublishYear: Int = 0,
    @SerializedName("first_sentence")
    val firstSentence: List<String> = listOf(),
    @SerializedName("format")
    val format: List<String> = listOf(),
    @SerializedName("has_fulltext")
    val hasFulltext: Boolean = false,
    @SerializedName("ia")
    val ia: List<String> = listOf(),
    @SerializedName("ia_box_id")
    val iaBoxId: List<String> = listOf(),
    @SerializedName("ia_collection")
    val iaCollection: List<String> = listOf(),
    @SerializedName("ia_collection_s")
    val iaCollectionS: String = "",
    @SerializedName("ia_loaded_id")
    val iaLoadedId: List<String> = listOf(),
    @SerializedName("id_alibris_id")
    val idAlibrisId: List<String> = listOf(),
    @SerializedName("id_amazon")
    val idAmazon: List<String> = listOf(),
    @SerializedName("id_amazon_ca_asin")
    val idAmazonCaAsin: List<String> = listOf(),
    @SerializedName("id_amazon_co_uk_asin")
    val idAmazonCoUkAsin: List<String> = listOf(),
    @SerializedName("id_amazon_de_asin")
    val idAmazonDeAsin: List<String> = listOf(),
    @SerializedName("id_amazon_it_asin")
    val idAmazonItAsin: List<String> = listOf(),
    @SerializedName("id_bcid")
    val idBcid: List<String> = listOf(),
    @SerializedName("id_better_world_books")
    val idBetterWorldBooks: List<String> = listOf(),
    @SerializedName("id_bibliothèque_nationale_de_france")
    val idBibliothèqueNationaleDeFrance: List<String> = listOf(),
    @SerializedName("id_british_library")
    val idBritishLibrary: List<String> = listOf(),
    @SerializedName("id_british_national_bibliography")
    val idBritishNationalBibliography: List<String> = listOf(),
    @SerializedName("id_canadian_national_library_archive")
    val idCanadianNationalLibraryArchive: List<String> = listOf(),
    @SerializedName("id_depósito_legal")
    val idDepósitoLegal: List<String> = listOf(),
    @SerializedName("id_dnb")
    val idDnb: List<String> = listOf(),
    @SerializedName("id_doi")
    val idDoi: List<String> = listOf(),
    @SerializedName("id_goodreads")
    val idGoodreads: List<String> = listOf(),
    @SerializedName("id_google")
    val idGoogle: List<String> = listOf(),
    @SerializedName("id_hathi_trust")
    val idHathiTrust: List<String> = listOf(),
    @SerializedName("id_librarything")
    val idLibrarything: List<String> = listOf(),
    @SerializedName("id_libris")
    val idLibris: List<String> = listOf(),
    @SerializedName("id_nla")
    val idNla: List<String> = listOf(),
    @SerializedName("id_overdrive")
    val idOverdrive: List<String> = listOf(),
    @SerializedName("id_paperback_swap")
    val idPaperbackSwap: List<String> = listOf(),
    @SerializedName("id_scribd")
    val idScribd: List<String> = listOf(),
    @SerializedName("id_wikidata")
    val idWikidata: List<String> = listOf(),
    @SerializedName("isbn")
    val isbn: List<String> = listOf(),
    @SerializedName("key")
    val key: String = "",
    @SerializedName("language")
    val language: List<String> = listOf(),
    @SerializedName("last_modified_i")
    val lastModifiedI: Int = 0,
    @SerializedName("lcc")
    val lcc: List<String> = listOf(),
    @SerializedName("lcc_sort")
    val lccSort: String = "",
    @SerializedName("lccn")
    val lccn: List<String> = listOf(),
    @SerializedName("lending_edition_s")
    val lendingEditionS: String = "",
    @SerializedName("lending_identifier_s")
    val lendingIdentifierS: String = "",
    @SerializedName("number_of_pages_median")
    val numberOfPagesMedian: Int = 0,
    @SerializedName("oclc")
    val oclc: List<String> = listOf(),
    @SerializedName("osp_count")
    val ospCount: Int = 0,
    @SerializedName("person")
    val person: List<String> = listOf(),
    @SerializedName("person_facet")
    val personFacet: List<String> = listOf(),
    @SerializedName("person_key")
    val personKey: List<String> = listOf(),
    @SerializedName("place")
    val place: List<String> = listOf(),
    @SerializedName("place_facet")
    val placeFacet: List<String> = listOf(),
    @SerializedName("place_key")
    val placeKey: List<String> = listOf(),
    @SerializedName("printdisabled_s")
    val printdisabledS: String = "",
    @SerializedName("public_scan_b")
    val publicScanB: Boolean = false,
    @SerializedName("publish_date")
    val publishDate: List<String> = listOf(),
    @SerializedName("publish_place")
    val publishPlace: List<String> = listOf(),
    @SerializedName("publish_year")
    val publishYear: List<Int> = listOf(),
    @SerializedName("publisher")
    val publisher: List<String> = listOf(),
    @SerializedName("publisher_facet")
    val publisherFacet: List<String> = listOf(),
    @SerializedName("ratings_average")
    val ratingsAverage: Double = 0.0,
    @SerializedName("ratings_count")
    val ratingsCount: Int = 0,
    @SerializedName("ratings_count_1")
    val ratingsCount1: Int = 0,
    @SerializedName("ratings_count_2")
    val ratingsCount2: Int = 0,
    @SerializedName("ratings_count_3")
    val ratingsCount3: Int = 0,
    @SerializedName("ratings_count_4")
    val ratingsCount4: Int = 0,
    @SerializedName("ratings_count_5")
    val ratingsCount5: Int = 0,
    @SerializedName("ratings_sortable")
    val ratingsSortable: Double = 0.0,
    @SerializedName("readinglog_count")
    val readinglogCount: Int = 0,
    @SerializedName("seed")
    val seed: List<String> = listOf(),
    @SerializedName("subject")
    val subject: List<String> = listOf(),
    @SerializedName("subject_facet")
    val subjectFacet: List<String> = listOf(),
    @SerializedName("subject_key")
    val subjectKey: List<String> = listOf(),
    @SerializedName("subtitle")
    val subtitle: String = "",
    @SerializedName("time")
    val time: List<String> = listOf(),
    @SerializedName("time_facet")
    val timeFacet: List<String> = listOf(),
    @SerializedName("time_key")
    val timeKey: List<String> = listOf(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("title_sort")
    val titleSort: String = "",
    @SerializedName("title_suggest")
    val titleSuggest: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("_version_")
    val version: Long = 0,
    @SerializedName("want_to_read_count")
    val wantToReadCount: Int = 0
)