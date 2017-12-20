package pandastudios.dotasound

import android.content.Context

class SoundArrays(val context: Context) {

    /**
     *  LISTS
     */
    val strength_heroes = arrayOf(
            R.drawable.hero_abaddon,
            R.drawable.hero_alchemist,
            R.drawable.hero_axe,
            R.drawable.hero_beastmaster,
            R.drawable.hero_brewmaster,
            R.drawable.hero_bristleback,
            R.drawable.hero_centaur,
            R.drawable.hero_ck,
            R.drawable.hero_clockwork,
            R.drawable.hero_doom,
            R.drawable.hero_dk,
            R.drawable.hero_earth,
            R.drawable.hero_es,
            R.drawable.hero_et,
            R.drawable.hero_huskar,
            R.drawable.hero_io,
            R.drawable.hero_kunkka,
            R.drawable.hero_lc,
            R.drawable.hero_ls,
            R.drawable.hero_lycan,
            R.drawable.hero_magnus,
            R.drawable.hero_ns,
            R.drawable.hero_omniknight,
            R.drawable.hero_phoenix,
            R.drawable.hero_pudge,
            R.drawable.hero_sk,
            R.drawable.hero_slardar,
            R.drawable.hero_sb,
            R.drawable.hero_sven,
            R.drawable.hero_tidehunter,
            R.drawable.hero_timber,
            R.drawable.hero_tiny,
            R.drawable.hero_treant,
            R.drawable.hero_tusk,
            R.drawable.hero_underlord,
            R.drawable.hero_undying,
            R.drawable.hero_wk
    )

    val agility_heroes = arrayOf(
            R.drawable.hero_am,
            R.drawable.hero_arc,
            R.drawable.hero_bs,
            R.drawable.hero_bh,
            R.drawable.hero_broodmother,
            R.drawable.hero_clinkz,
            R.drawable.hero_drow,
            R.drawable.hero_ember,
            R.drawable.hero_void,
            R.drawable.hero_gyro,
            R.drawable.hero_jug,
            R.drawable.hero_ld,
            R.drawable.hero_luna,
            R.drawable.hero_medusa,
            R.drawable.hero_meepo,
            R.drawable.hero_mirana,
            R.drawable.hero_mk,
            R.drawable.hero_morph,
            R.drawable.hero_naga,
            R.drawable.hero_nyx,
            R.drawable.hero_pango,
            R.drawable.hero_pa,
            R.drawable.hero_pl,
            R.drawable.hero_razor,
            R.drawable.hero_riki,
            R.drawable.hero_sf,
            R.drawable.hero_slark,
            R.drawable.hero_sniper,
            R.drawable.hero_spectre,
            R.drawable.hero_ta,
            R.drawable.hero_tb,
            R.drawable.hero_troll,
            R.drawable.hero_ursa,
            R.drawable.hero_venge,
            R.drawable.hero_veno,
            R.drawable.hero_viper,
            R.drawable.hero_weaver
    )

    val intelligence_heroes = arrayOf(
            R.drawable.hero_aa,
            R.drawable.hero_bane,
            R.drawable.hero_batrider,
            R.drawable.hero_chen,
            R.drawable.hero_cm,
            R.drawable.hero_ds,
            R.drawable.hero_dw,
            R.drawable.hero_dazzle,
            R.drawable.hero_dp,
            R.drawable.hero_disruptor,
            R.drawable.hero_enchantress,
            R.drawable.hero_enigma,
            R.drawable.hero_invoker,
            R.drawable.hero_jakiro,
            R.drawable.hero_kotl,
            R.drawable.hero_leshrac,
            R.drawable.hero_lich,
            R.drawable.hero_lina,
            R.drawable.hero_lion,
            R.drawable.hero_np,
            R.drawable.hero_necro,
            R.drawable.hero_ogre,
            R.drawable.hero_oracle,
            R.drawable.hero_od,
            R.drawable.hero_puck,
            R.drawable.hero_pugna,
            R.drawable.hero_qop,
            R.drawable.hero_rubick,
            R.drawable.hero_sd,
            R.drawable.hero_ss,
            R.drawable.hero_silencer,
            R.drawable.hero_sm,
            R.drawable.hero_storm,
            R.drawable.hero_techies,
            R.drawable.hero_tinker,
            R.drawable.hero_visage,
            R.drawable.hero_warlock,
            R.drawable.hero_wr,
            R.drawable.hero_ww,
            R.drawable.hero_wd,
            R.drawable.hero_zeus
    )

    val misc_items = arrayOf(
            R.drawable.board_header_ti7
    )

    // MISC BOARDS

    // The Internationals 2017
    val ti7_board_header = R.drawable.board_header_ti7
    val ti7_sound_res = arrayListOf(
            R.raw.ti7_applause,
            R.raw.ti7_ay_ay_ay,
            R.raw.ti7_ba_dum_tishh,
            R.raw.ti7_bozhe_ti_posmotri,
            R.raw.ti7_brutal_savage_rekt,
            R.raw.ti7_charge,
            R.raw.ti7_crash_and_burn,
            R.raw.ti7_crickets,
            R.raw.ti7_crybaby,
            R.raw.ti7_drum_roll,
            R.raw.ti7_ehto_gg,
            R.raw.ti7_eto_prosto_netchto,
            R.raw.ti7_frog,
            R.raw.ti7_headshake,
            R.raw.ti7_its_a_disastah,
            R.raw.ti7_jia_you,
            R.raw.ti7_patience_from_zhou,
            R.raw.ti7_po_liang_lu,
            R.raw.ti7_sad_trombone,
            R.raw.ti7_sproing,
            R.raw.ti7_theyre_all_dead,
            R.raw.ti7_tian_huo,
            R.raw.ti7_wan_bu_liao_la,
            R.raw.ti7_waow,
            R.raw.ti7_zhil_do_konsta,
            R.raw.ti7_zou_hao_bu_song
    )
    val ti7_sound_titles = arrayListOf<String>(
            context.getString(R.string.ti7_applause),
            context.getString(R.string.ti7_ay_ay_ay),
            context.getString(R.string.ti7_ba_dum_tishh),
            context.getString(R.string.ti7_bozhe_ti_posmotri),
            context.getString(R.string.ti7_brutal_savage_rekt),
            context.getString(R.string.ti7_charge),
            context.getString(R.string.ti7_crash_and_burn),
            context.getString(R.string.ti7_crickets),
            context.getString(R.string.ti7_crybaby),
            context.getString(R.string.ti7_drum_roll),
            context.getString(R.string.ti7_ehto_gg),
            context.getString(R.string.ti7_eto_prosto_netchto),
            context.getString(R.string.ti7_frog),
            context.getString(R.string.ti7_headshake),
            context.getString(R.string.ti7_its_a_disastah),
            context.getString(R.string.ti7_jia_you),
            context.getString(R.string.ti7_patience_from_zhou),
            context.getString(R.string.ti7_po_liang_lu),
            context.getString(R.string.ti7_sad_trombone),
            context.getString(R.string.ti7_sproing),
            context.getString(R.string.ti7_theyre_all_dead),
            context.getString(R.string.ti7_tian_huo),
            context.getString(R.string.ti7_wan_bu_liao_la),
            context.getString(R.string.ti7_waow),
            context.getString(R.string.ti7_zhil_do_konsta),
            context.getString(R.string.ti7_zou_hao_bu_song)
    )

    // STRENGTH HEROES

    // Abaddon
    val board_header_abaddon = R.drawable.header_abaddon
    val abaddon_sound_res_attack = arrayListOf(
            R.raw.dialogue_abaddon_ha_ha_ha,
            R.raw.dialogue_abaddon_hm_hm_hm_1,
            R.raw.dialogue_abaddon_hm_hm_hm_2,
            R.raw.dialogue_abaddon_my_life_spend,
            R.raw.dialogue_abaddon_shizzy_wizard,
            R.raw.dialogue_abaddon_such_power,
            R.raw.dialogue_abaddon_victory
    )
    val abaddon_sound_titles_attack = arrayListOf<String>(
            context.getString(R.string.abaddon_hahaha),
            context.getString(R.string.abaddon_hmhmhm1),
            context.getString(R.string.abaddon_hmhmhm2),
            context.getString(R.string.abaddon_my_life_is_mine_to_spend),
            context.getString(R.string.abaddon_sh_wizard),
            context.getString(R.string.abaddon_such_power),
            context.getString(R.string.abaddon_victory)
    )

    val abaddon_sound_res_abilities = arrayListOf(
            R.raw.dialogue_abaddon_death_for_you,
            R.raw.dialogue_abaddon_its_not_time_yet,
            R.raw.dialogue_abaddon_scepter
    )
    val abaddon_sound_titles_abilities = arrayListOf<String>(
            context.getString(R.string.abaddon_death_for_you),
            context.getString(R.string.abaddon_its_not_time_yet),
            context.getString(R.string.abaddon_ah_scepter)
    )

    // Alchemist
    val board_header_alchemist = R.drawable.header_alchemist
    val alchemist_sound_res_attack = arrayListOf(
            R.raw.dialogue_alchemist_duck,
            R.raw.dialogue_alchemist_happiness_bought,
            R.raw.dialogue_alchemist_i_think_ill_be_okay,
            R.raw.dialogue_alchemist_im_feeling_punchy,
            R.raw.dialogue_alchemist_okey_dokey,
            R.raw.dialogue_alchemist_shizzy_wizard
    )
    val alchemist_sound_res_attack_morphed = arrayListOf(
            R.raw.dialogue_alchemist_duck,
            R.raw.dialogue_alchemist_happiness_bought,
            R.raw.dialogue_alchemist_i_think_ill_be_okay,
            R.raw.dialogue_alchemist_im_feeling_punchy,
            R.raw.dialogue_alchemist_okey_dokey,
            R.raw.dialogue_alchemist_shizzy_wizard
    )
    val alchemist_sound_titles_attack = arrayListOf<String>(
            context.getString(R.string.alchemist_duck),
            context.getString(R.string.alchemist_happiness_can_be_bought),
            context.getString(R.string.alchemist_i_think_ok),
            context.getString(R.string.alchemist_im_feeling_punchy),
            context.getString(R.string.alchemist_okey_dokey),
            context.getString(R.string.alchemist_sh_wizard)
    )

    val alchemist_sound_res_abilities = arrayListOf(
            R.raw.dialogue_alchemist_alchemy_is_the_future,
            R.raw.dialogue_alchemist_greed_is_good,
            R.raw.dialogue_alchemist_im_not_ready,
            R.raw.dialogue_alchemist_throw_thing
    )
    val alchemist_sound_res_abilities_morphed = arrayListOf(
            R.raw.dialogue_alchemist_alchemy_is_the_future,
            R.raw.dialogue_alchemist_greed_is_good,
            R.raw.dialogue_alchemist_im_not_ready,
            R.raw.dialogue_alchemist_throw_thing
    )
    val alchemist_sound_titles_abilities = arrayListOf<String>(
            context.getString(R.string.alchemist_alchemy_future),
            context.getString(R.string.alchemist_greed_is_good),
            context.getString(R.string.alchemist_im_not_ready),
            context.getString(R.string.alchemist_throw_the_thing)
    )

    // Axe
    val board_header_axe = R.drawable.header_axe

    // Beastmaster
    val board_header_beastmaster = R.drawable.header_beastmaster

    // Brewmaster
    val board_header_brewmaster = R.drawable.header_brewmaster

    // Bristleback
    val board_header_bristleback = R.drawable.header_bristleback

    // Centaur Warrunner
    val board_header_centaur = R.drawable.header_centaur

    // Chaos Knight
    val board_header_ck = R.drawable.header_ck

    // Clockwork
    val board_header_clock = R.drawable.header_clockwerk

    // Doom
    val board_header_doom = R.drawable.header_doom

    // Dragon Knight
    val board_header_dk = R.drawable.header_dk

    // Earth Spirit
    val board_header_earth = R.drawable.header_earth

    // Earthshaker
    val board_header_es = R.drawable.header_es

    // Elder Titan
    val board_header_elder = R.drawable.header_et

    // Huskar
    val board_header_huskar = R.drawable.header_huskar

    // Io
    val board_header_io = R.drawable.header_io

    // Kunkka
    val board_header_kunkka = R.drawable.header_kunkka

    // Legion Commander
    val board_header_lc = R.drawable.header_lc

    // Lifestealer
    val board_header_lifestealer = R.drawable.header_lifestealer

    // Lycan
    val board_header_lycan = R.drawable.header_lycan

    // Magnus
    val board_header_magnus = R.drawable.header_magnus

    // Night Stalker
    val board_header_ns = R.drawable.header_ns

    // Omniknight
    val board_header_omniknight = R.drawable.header_omniknight

    // Phoenix
    val board_header_phoenix = R.drawable.header_phoenix

    // Pudge
    val board_header_pudge = R.drawable.header_pudge

    // Sand King
    val board_header_sk = R.drawable.header_sk

    // Slardar
    val board_header_slardar = R.drawable.header_slardar

    // Spirit Breaker
    val board_header_sb = R.drawable.header_sb

    // Sven
    val board_header_sven = R.drawable.header_sven

    // Tidehunter
    val board_header_tide = R.drawable.header_tidehunter

    // Timbersaw
    val board_header_timber = R.drawable.header_timbersaw

    // Tiny
    val board_header_tiny = R.drawable.header_tiny

    // Treant Protector
    val board_header_treant = R.drawable.header_treant

    // Tusk
    val board_header_tusk = R.drawable.header_tusk

    // Underlord
    val board_header_underlord = R.drawable.header_underlord

    // Undying
    val board_header_undying = R.drawable.header_undying

    // Wraith King
    val board_header_wk = R.drawable.header_wk

    // AGILITY HEROES
    // Anti-mage
    val board_header_antimage = R.drawable.header_am

    // Arc Warden
    val board_header_arc = R.drawable.header_aw

    // Bloodseeker
    val board_header_bloodseeker = R.drawable.header_bloodseeker

    // Bounty Hunter
    val board_header_bh = R.drawable.header_bh

    // Broodmother
    val board_header_brood = R.drawable.header_broodmother

    // Clinkz
    val board_header_clinkz = R.drawable.header_clinkz

    // Drow Ranger
    val board_header_drow = R.drawable.header_drow

    // Ember Spirit
    val board_header_ember = R.drawable.header_ember

    // Faceless Void
    val board_header_faceless = R.drawable.header_faceless

    // Gyrocopter
    val board_header_gyro = R.drawable.header_gyrocopter

    // Juggernaut
    val board_header_juggernaut = R.drawable.header_juggernaut

    // Lone Druid
    val board_header_ld = R.drawable.header_ld

    // Luna
    val board_header_luna = R.drawable.header_luna

    // Medusa
    val board_header_medusa = R.drawable.header_medusa

    // Meepo
    val board_header_meepo = R.drawable.header_meepo

    // Mirana
    val board_header_mirana = R.drawable.header_mirana

    // Monkey King
    val board_header_mk = R.drawable.header_mk

    // Morphling
    val board_header_morph = R.drawable.header_morphling

    // Naga Siren
    val board_header_naga = R.drawable.header_naga

    // Nyx
    val board_header_nyx = R.drawable.header_nyx

    // Pangolier
    val board_header_pango = R.drawable.header_pangolier

    // Phantom Assassin
    val board_header_pa = R.drawable.header_pa

    // Phantom Lancer
    val board_header_pl = R.drawable.header_pl

    // Razor
    val board_header_razor = R.drawable.header_razor

    // Riki
    val board_header_riki = R.drawable.header_riki

    // Shadow Fiend
    val board_header_sf = R.drawable.header_sf

    // Slark
    val board_header_slark = R.drawable.header_slark

    // Sniper
    val board_header_sniper = R.drawable.header_sniper

    // Spectre
    val board_header_spectre = R.drawable.header_spectre

    // Templar Assassin
    val board_header_ta = R.drawable.header_ta

    // Terrorblade
    val board_header_terrorblade = R.drawable.header_terrorblade

    // Troll Warlord
    val board_header_troll = R.drawable.header_troll

    // Ursa
    val board_header_ursa = R.drawable.header_ursa

    // Vengeful Spirit
    val board_header_vengeful = R.drawable.header_vengeful

    // Venomancer
    val board_header_venomancer = R.drawable.header_venomancer

    // Viper
    val board_header_viper = R.drawable.header_viper

    // Weaver
    val board_header_weaver = R.drawable.header_weaver

    // INTELLIGENCE HEROES
    val board_header_ancient = R.drawable.header_ancient_apparition

    // Bane
    val board_header_bane = R.drawable.header_bane

    // Batrider
    val board_header_batrider = R.drawable.header_batrider

    // Chen
    val board_header_chen = R.drawable.header_chen

    // Crystal Maiden
    val board_header_cm = R.drawable.header_cm

    // Dark Seer
    val board_header_ds = R.drawable.header_ds

    // Dark Willow
    val board_header_dw = R.drawable.header_dw

    // Dazzle
    val board_header_dazzle = R.drawable.header_dazzle

    // Death Prophet
    val board_header_dp = R.drawable.header_dp

    // Disruptor
    val board_header_disruptor = R.drawable.header_disruptor

    // Enchantress
    val board_header_enchantress = R.drawable.header_enchantress

    // Engima
    val board_header_enigma = R.drawable.header_enigma

    // Invoker
    val board_header_invoker = R.drawable.header_invoker

    // Jakiro
    val board_header_jakiro = R.drawable.header_jakiro

    // Keeper of the Light
    val board_header_kotl = R.drawable.header_kotl

    // Leshrac
    val board_header_leshrac = R.drawable.header_leshrac

    // Lich
    val board_header_lich = R.drawable.header_lich

    // Lina
    val board_header_lina = R.drawable.header_lina

    // Lion
    val board_header_lion = R.drawable.header_lion

    // Nature's Prophet
    val board_header_np = R.drawable.header_np

    // Necrophos
    val board_header_necro = R.drawable.header_necrophos

    // Ogre Magi
    val board_header_ogre = R.drawable.header_ogre

    // Oracle
    val board_header_oracle = R.drawable.header_oracle

    // Outworld Devourer
    val board_header_od = R.drawable.header_od

    // Puck
    val board_header_puck = R.drawable.header_puck

    // Pugna
    val board_header_pugna = R.drawable.header_pugna

    // Queen of Pain
    val board_header_qop = R.drawable.header_qop

    // Rubick
    val board_header_rubick = R.drawable.header_rubick

    // Shadow Demon
    val board_header_sd = R.drawable.header_sd

    // Shadow Shaman
    val board_header_ss = R.drawable.header_ss

    // Silencer
    val board_header_silencer = R.drawable.header_silencer

    // Skywrath Mage
    val board_header_sm = R.drawable.header_sm

    // Storm Spirit
    val board_header_storm = R.drawable.header_storm

    // Techies
    val board_header_techies = R.drawable.header_techies

    // Tinker
    val board_header_tinker = R.drawable.header_tinker

    // Visage
    val board_header_visage = R.drawable.header_visage

    // Warlock
    val board_header_warlock = R.drawable.header_warlock

    // Windranger
    val board_header_wr = R.drawable.header_wr

    // Winter Wyvern
    val board_header_ww = R.drawable.header_ww

    // Witch Doctor
    val board_header_wd = R.drawable.header_wd

    // Zeus
    val board_header_zeus = R.drawable.header_zeus

    // Board Headers
    val strength_board_headers = arrayOf(
            board_header_alchemist,
            board_header_abaddon,
            board_header_axe,
            board_header_beastmaster,
            board_header_brewmaster,
            board_header_bristleback,
            board_header_centaur,
            board_header_ck,
            board_header_clock,
            board_header_doom,
            board_header_dk,
            board_header_earth,
            board_header_es,
            board_header_elder,
            board_header_huskar,
            board_header_io,
            board_header_kunkka,
            board_header_lc,
            board_header_lifestealer,
            board_header_lycan,
            board_header_magnus,
            board_header_ns,
            board_header_omniknight,
            board_header_phoenix,
            board_header_pudge,
            board_header_sk,
            board_header_slardar,
            board_header_sb,
            board_header_sven,
            board_header_tide,
            board_header_timber,
            board_header_tiny,
            board_header_treant,
            board_header_tusk,
            board_header_underlord,
            board_header_undying,
            board_header_wk
    )

    val agility_board_headers = arrayOf(
            board_header_antimage,
            board_header_arc,
            board_header_bloodseeker,
            board_header_bh,
            board_header_brood,
            board_header_clinkz,
            board_header_drow,
            board_header_ember,
            board_header_faceless,
            board_header_gyro,
            board_header_juggernaut,
            board_header_ld,
            board_header_luna,
            board_header_medusa,
            board_header_meepo,
            board_header_mirana,
            board_header_mk,
            board_header_morph,
            board_header_naga,
            board_header_nyx,
            board_header_pango,
            board_header_pa,
            board_header_pl,
            board_header_razor,
            board_header_riki,
            board_header_sf,
            board_header_slark,
            board_header_sniper,
            board_header_spectre,
            board_header_ta,
            board_header_terrorblade,
            board_header_troll,
            board_header_ursa,
            board_header_vengeful,
            board_header_venomancer,
            board_header_viper,
            board_header_weaver
    )

    val intelligence_board_headers = arrayOf(
            board_header_ancient,
            board_header_bane,
            board_header_batrider,
            board_header_chen,
            board_header_cm,
            board_header_ds,
            board_header_dw,
            board_header_dazzle,
            board_header_dp,
            board_header_disruptor,
            board_header_enchantress,
            board_header_enigma,
            board_header_invoker,
            board_header_jakiro,
            board_header_kotl,
            board_header_leshrac,
            board_header_lich,
            board_header_lina,
            board_header_lion,
            board_header_np,
            board_header_necro,
            board_header_ogre,
            board_header_oracle,
            board_header_od,
            board_header_puck,
            board_header_pugna,
            board_header_qop,
            board_header_rubick,
            board_header_sd,
            board_header_ss,
            board_header_silencer,
            board_header_sm,
            board_header_storm,
            board_header_techies,
            board_header_tinker,
            board_header_visage,
            board_header_warlock,
            board_header_wr,
            board_header_ww,
            board_header_wd,
            board_header_zeus
    )

    val misc_board_headers = arrayOf(
            R.drawable.board_header_ti7
    )


}