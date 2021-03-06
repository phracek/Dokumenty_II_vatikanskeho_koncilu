#!/bin/bash

# MAIN URL http://www.vatican.va/archive/hist_councils/ii_vatican_council/index.htm

# Consitutions
dei_verbum_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_const_19651118_dei-verbum"
lumen_gentium_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_const_19641121_lumen-gentium"
sacrosanctum_concilium_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_const_19631204_sacrosanctum-concilium"
gaudium_et_spes_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_const_19651207_gaudium-et-spes"

# Declarations
gravissimum_educationis_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decl_19651028_gravissimum-educationis"
nostra_aetate_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decl_19651028_nostra-aetate"
dignitatis_humanae_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decl_19651207_dignitatis-humanae"

# Decrees
ad_gentes_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19651207_ad-gentes"
optatam_totius_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19651028_optatam-totius"
presbyterorum_ordinis_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19651207_presbyterorum-ordinis"
apostolicam_actuositatem_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19651118_apostolicam-actuositatem"
perfectae_caritatis_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19651028_perfectae-caritatis"
christus_dominus_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19651028_christus-dominus"
unitatis_redintegratio_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19641121_unitatis-redintegratio"
orientalium_ecclesiarum_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19641121_orientalium-ecclesiarum"
inter_mirifica_URL="http://www.vatican.va/archive/hist_councils/ii_vatican_council/documents/vat-ii_decree_19631204_inter-mirifica"

function create_db {
    pwd=`pwd`
    cd docs
    document="database"
    [[ -f $document ]] && rm -f $document
    for lang in cs en lt; do
        # Download Consitutions
        for doc in dei_verbum lumen_gentium sacrosanctum_concilium gaudium_et_spes; do
            temp=`cat $doc-$lang.html | tr '\r\n' ' '`
            echo "$lang::$doc::$temp" >> $document
        done
        # Download Declarations
        for doc in gravissimum_educationis nostra_aetate dignitatis_humanae; do
            temp=`cat $doc-$lang.html | tr '\r\n' ' '`
            echo "$lang::$doc::$temp" >> $document
        done
        # Download Decrees
        for doc in ad_gentes presbyterorum_ordinis apostolicam_actuositatem optatam_totius perfectae_caritatis christus_dominus unitatis_redintegratio orientalium_ecclesiarum inter_mirifica; do
            temp=`cat $doc-$lang.html | tr '\r\n' ' '`
            echo "$lang::$doc::$temp" >> $document
        done
    done
    cd $pwd
}

function download_docs {
    for lang in cs en lt; do
        # Download Consitutions
        for doc in dei_verbum lumen_gentium sacrosanctum_concilium gaudium_et_spes; do
            echo "Download $doc"
            VAL="`echo $doc`_URL"
            wget -O $doc-$lang.html ${!VAL}_$lang.html
        done
        # Download Declarations
        for doc in gravissimum_educationis nostra_aetate dignitatis_humanae; do
            echo "Download $doc"
            VAL="`echo $doc`_URL"
            wget -O $doc-$lang.html ${!VAL}_$lang.html
        done
        # Download Decrees
        for doc in ad_gentes presbyterorum_ordinis apostolicam_actuositatem optatam_totius perfectae_caritatis christus_dominus unitatis_redintegratio orientalium_ecclesiarum inter_mirifica; do
            echo "Download $doc"
            VAL="`echo $doc`_URL"
            echo "$VAL"
            echo "${!VAL}_$lang.html"
            wget -O $doc-$lang.html ${!VAL}_$lang.html
        done
    done
}

if [[ "$1" == "download" ]]; then
    download_docs 
    exit 0
fi

if [[ "$1" == "database" ]]; then
    create_db
    exit 0
fi
