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
            R.drawable.board_header_ti7,
            R.drawable.header_rickandmorty
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

    val rickandmorty_board_header = R.drawable.header_rickandmorty
    val rickandmorty_sound_res_Encounters = arrayListOf(
            R.raw.dialogue_rickandmorty_to_abaddon,
            R.raw.dialogue_rickandmorty_to_alchemist,
            R.raw.dialogue_rickandmorty_to_ancient_apparition,
            R.raw.dialogue_rickandmorty_to_antimage,
            R.raw.dialogue_rickandmorty_to_arc_warden,
            R.raw.dialogue_rickandmorty_to_axe,
            R.raw.dialogue_rickandmorty_to_bane_1,
            R.raw.dialogue_rickandmorty_to_bane_2,
            R.raw.dialogue_rickandmorty_to_batrider,
            R.raw.dialogue_rickandmorty_to_beastmaster,
            R.raw.dialogue_rickandmorty_to_bloodseeker,
            R.raw.dialogue_rickandmorty_to_bounty_hunter,
            R.raw.dialogue_rickandmorty_to_brewmaster,
            R.raw.dialogue_rickandmorty_to_bristleback,
            R.raw.dialogue_rickandmorty_to_broodmother,
            R.raw.dialogue_rickandmorty_to_centaur,
            R.raw.dialogue_rickandmorty_to_chaos_knight,
            R.raw.dialogue_rickandmorty_to_chen,
            R.raw.dialogue_rickandmorty_to_clinks,
            R.raw.dialogue_rickandmorty_to_clockwork,
            R.raw.dialogue_rickandmorty_to_crystal_maiden,
            R.raw.dialogue_rickandmorty_to_dark_seer,
            R.raw.dialogue_rickandmorty_to_dazzle,
            R.raw.dialogue_rickandmorty_to_death_prophet,
            R.raw.dialogue_rickandmorty_to_disruptor,
            R.raw.dialogue_rickandmorty_to_doom,
            R.raw.dialogue_rickandmorty_to_dragon_knight,
            R.raw.dialogue_rickandmorty_to_drow_ranger,
            R.raw.dialogue_rickandmorty_to_earthshaker,
            R.raw.dialogue_rickandmorty_to_earth_spirit,
            R.raw.dialogue_rickandmorty_to_elder_titan,
            R.raw.dialogue_rickandmorty_to_ember_spirit,
            R.raw.dialogue_rickandmorty_to_enchantress,
            R.raw.dialogue_rickandmorty_to_enigma,
            R.raw.dialogue_rickandmorty_to_faceless_void,
            R.raw.dialogue_rickandmorty_to_females,
            R.raw.dialogue_rickandmorty_to_fire,
            R.raw.dialogue_rickandmorty_to_gyrocopter,
            R.raw.dialogue_rickandmorty_to_handsomes,
            R.raw.dialogue_rickandmorty_to_healers,
            R.raw.dialogue_rickandmorty_to_huskar,
            R.raw.dialogue_rickandmorty_to_illusionists_1,
            R.raw.dialogue_rickandmorty_to_illusionists_2,
            R.raw.dialogue_rickandmorty_to_interdimensionals,
            R.raw.dialogue_rickandmorty_to_invoker_1,
            R.raw.dialogue_rickandmorty_to_invoker_2,
            R.raw.dialogue_rickandmorty_to_invoker_3,
            R.raw.dialogue_rickandmorty_to_io,
            R.raw.dialogue_rickandmorty_to_jakiro,
            R.raw.dialogue_rickandmorty_to_juggernaut,
            R.raw.dialogue_rickandmorty_to_kotl_1,
            R.raw.dialogue_rickandmorty_to_kotl_2,
            R.raw.dialogue_rickandmorty_to_kunkka,
            R.raw.dialogue_rickandmorty_to_leshrac_1,
            R.raw.dialogue_rickandmorty_to_leshrac_2,
            R.raw.dialogue_rickandmorty_to_lich,
            R.raw.dialogue_rickandmorty_to_lifestealer,
            R.raw.dialogue_rickandmorty_to_lina,
            R.raw.dialogue_rickandmorty_to_lion,
            R.raw.dialogue_rickandmorty_to_lone_druid,
            R.raw.dialogue_rickandmorty_to_luna,
            R.raw.dialogue_rickandmorty_to_lycan,
            R.raw.dialogue_rickandmorty_to_magnus,
            R.raw.dialogue_rickandmorty_to_medusa_1,
            R.raw.dialogue_rickandmorty_to_medusa_2,
            R.raw.dialogue_rickandmorty_to_meepo_1,
            R.raw.dialogue_rickandmorty_to_meepo_2,
            R.raw.dialogue_rickandmorty_to_mirana,
            R.raw.dialogue_rickandmorty_to_morphling_1,
            R.raw.dialogue_rickandmorty_to_morphling_2,
            R.raw.dialogue_rickandmorty_to_naga_siren,
            R.raw.dialogue_rickandmorty_to_natures_prophet,
            R.raw.dialogue_rickandmorty_to_necrophos,
            R.raw.dialogue_rickandmorty_to_nyx,
            R.raw.dialogue_rickandmorty_to_ogre_1,
            R.raw.dialogue_rickandmorty_to_ogre_2,
            R.raw.dialogue_rickandmorty_to_outworld_devourer,
            R.raw.dialogue_rickandmorty_to_phantom_assassin,
            R.raw.dialogue_rickandmorty_to_phoenix,
            R.raw.dialogue_rickandmorty_to_puck,
            R.raw.dialogue_rickandmorty_to_pudge,
            R.raw.dialogue_rickandmorty_to_pugna,
            R.raw.dialogue_rickandmorty_to_queen_of_pain,
            R.raw.dialogue_rickandmorty_to_razor,
            R.raw.dialogue_rickandmorty_to_riki,
            R.raw.dialogue_rickandmorty_to_rubick,
            R.raw.dialogue_rickandmorty_to_sand_king,
            R.raw.dialogue_rickandmorty_to_shadow_demon,
            R.raw.dialogue_rickandmorty_to_shadow_fiend,
            R.raw.dialogue_rickandmorty_to_shadow_shaman,
            R.raw.dialogue_rickandmorty_to_silencer,
            R.raw.dialogue_rickandmorty_to_skeletons,
            R.raw.dialogue_rickandmorty_to_skywrath_1,
            R.raw.dialogue_rickandmorty_to_skywrath_2,
            R.raw.dialogue_rickandmorty_to_slardar,
            R.raw.dialogue_rickandmorty_to_slark_1,
            R.raw.dialogue_rickandmorty_to_slark_2,
            R.raw.dialogue_rickandmorty_to_slark_3,
            R.raw.dialogue_rickandmorty_to_sniper,
            R.raw.dialogue_rickandmorty_to_spectre,
            R.raw.dialogue_rickandmorty_to_spirit_breaker,
            R.raw.dialogue_rickandmorty_to_storm_spirit,
            R.raw.dialogue_rickandmorty_to_sven,
            R.raw.dialogue_rickandmorty_to_techies_1,
            R.raw.dialogue_rickandmorty_to_techies_2,
            R.raw.dialogue_rickandmorty_to_terrorblade,
            R.raw.dialogue_rickandmorty_to_tidehunter_1,
            R.raw.dialogue_rickandmorty_to_tidehunter_2,
            R.raw.dialogue_rickandmorty_to_tinker_1,
            R.raw.dialogue_rickandmorty_to_tinker_2,
            R.raw.dialogue_rickandmorty_to_tinker_3,
            R.raw.dialogue_rickandmorty_to_tiny,
            R.raw.dialogue_rickandmorty_to_treant_1,
            R.raw.dialogue_rickandmorty_to_treant_2,
            R.raw.dialogue_rickandmorty_to_treant_3,
            R.raw.dialogue_rickandmorty_to_troll_warlord,
            R.raw.dialogue_rickandmorty_to_tusk,
            R.raw.dialogue_rickandmorty_to_underlord,
            R.raw.dialogue_rickandmorty_to_undying_1,
            R.raw.dialogue_rickandmorty_to_undying_2,
            R.raw.dialogue_rickandmorty_to_ursa,
            R.raw.dialogue_rickandmorty_to_vengeful_spirit,
            R.raw.dialogue_rickandmorty_to_venomancer,
            R.raw.dialogue_rickandmorty_to_viper,
            R.raw.dialogue_rickandmorty_to_visage,
            R.raw.dialogue_rickandmorty_to_warlock,
            R.raw.dialogue_rickandmorty_to_weaver,
            R.raw.dialogue_rickandmorty_to_winter_wyvern,
            R.raw.dialogue_rickandmorty_to_witch_doctor,
            R.raw.dialogue_rickandmorty_to_wizards,
            R.raw.dialogue_rickandmorty_to_wraith_king,
            R.raw.dialogue_rickandmorty_to_zeus
    )

    val rickandmorty_sound_titles_Encounters = arrayListOf<String>(
            context.getString(R.string.dialogue_rickandmorty_to_abaddon),
            context.getString(R.string.dialogue_rickandmorty_to_alchemist),
            context.getString(R.string.dialogue_rickandmorty_to_ancient_apparition),
            context.getString(R.string.dialogue_rickandmorty_to_antimage),
            context.getString(R.string.dialogue_rickandmorty_to_arc_warden),
            context.getString(R.string.dialogue_rickandmorty_to_axe),
            context.getString(R.string.dialogue_rickandmorty_to_bane_1),
            context.getString(R.string.dialogue_rickandmorty_to_bane_2),
            context.getString(R.string.dialogue_rickandmorty_to_batrider),
            context.getString(R.string.dialogue_rickandmorty_to_beastmaster),
            context.getString(R.string.dialogue_rickandmorty_to_bloodseeker),
            context.getString(R.string.dialogue_rickandmorty_to_bounty_hunter),
            context.getString(R.string.dialogue_rickandmorty_to_brewmaster),
            context.getString(R.string.dialogue_rickandmorty_to_bristleback),
            context.getString(R.string.dialogue_rickandmorty_to_broodmother),
            context.getString(R.string.dialogue_rickandmorty_to_centaur),
            context.getString(R.string.dialogue_rickandmorty_to_chaos_knight),
            context.getString(R.string.dialogue_rickandmorty_to_chen),
            context.getString(R.string.dialogue_rickandmorty_to_clinks),
            context.getString(R.string.dialogue_rickandmorty_to_clockwork),
            context.getString(R.string.dialogue_rickandmorty_to_crystal_maiden),
            context.getString(R.string.dialogue_rickandmorty_to_dark_seer),
            context.getString(R.string.dialogue_rickandmorty_to_dazzle),
            context.getString(R.string.dialogue_rickandmorty_to_death_prophet),
            context.getString(R.string.dialogue_rickandmorty_to_disruptor),
            context.getString(R.string.dialogue_rickandmorty_to_doom),
            context.getString(R.string.dialogue_rickandmorty_to_dragon_knight),
            context.getString(R.string.dialogue_rickandmorty_to_drow_ranger),
            context.getString(R.string.dialogue_rickandmorty_to_earthshaker),
            context.getString(R.string.dialogue_rickandmorty_to_earth_spirit),
            context.getString(R.string.dialogue_rickandmorty_to_elder_titan),
            context.getString(R.string.dialogue_rickandmorty_to_ember_spirit),
            context.getString(R.string.dialogue_rickandmorty_to_enchantress),
            context.getString(R.string.dialogue_rickandmorty_to_enigma),
            context.getString(R.string.dialogue_rickandmorty_to_faceless_void),
            context.getString(R.string.dialogue_rickandmorty_to_females),
            context.getString(R.string.dialogue_rickandmorty_to_fire),
            context.getString(R.string.dialogue_rickandmorty_to_gyrocopter),
            context.getString(R.string.dialogue_rickandmorty_to_handsomes),
            context.getString(R.string.dialogue_rickandmorty_to_healers),
            context.getString(R.string.dialogue_rickandmorty_to_huskar),
            context.getString(R.string.dialogue_rickandmorty_to_illusionists_1),
            context.getString(R.string.dialogue_rickandmorty_to_illusionists_2),
            context.getString(R.string.dialogue_rickandmorty_to_interdimensionals),
            context.getString(R.string.dialogue_rickandmorty_to_invoker_1),
            context.getString(R.string.dialogue_rickandmorty_to_invoker_2),
            context.getString(R.string.dialogue_rickandmorty_to_invoker_3),
            context.getString(R.string.dialogue_rickandmorty_to_io),
            context.getString(R.string.dialogue_rickandmorty_to_jakiro),
            context.getString(R.string.dialogue_rickandmorty_to_juggernaut),
            context.getString(R.string.dialogue_rickandmorty_to_kotl_1),
            context.getString(R.string.dialogue_rickandmorty_to_kotl_2),
            context.getString(R.string.dialogue_rickandmorty_to_kunkka),
            context.getString(R.string.dialogue_rickandmorty_to_leshrac_1),
            context.getString(R.string.dialogue_rickandmorty_to_leshrac_2),
            context.getString(R.string.dialogue_rickandmorty_to_lich),
            context.getString(R.string.dialogue_rickandmorty_to_lifestealer),
            context.getString(R.string.dialogue_rickandmorty_to_lina),
            context.getString(R.string.dialogue_rickandmorty_to_lion),
            context.getString(R.string.dialogue_rickandmorty_to_lone_druid),
            context.getString(R.string.dialogue_rickandmorty_to_luna),
            context.getString(R.string.dialogue_rickandmorty_to_lycan),
            context.getString(R.string.dialogue_rickandmorty_to_magnus),
            context.getString(R.string.dialogue_rickandmorty_to_medusa_1),
            context.getString(R.string.dialogue_rickandmorty_to_medusa_2),
            context.getString(R.string.dialogue_rickandmorty_to_meepo_1),
            context.getString(R.string.dialogue_rickandmorty_to_meepo_2),
            context.getString(R.string.dialogue_rickandmorty_to_mirana),
            context.getString(R.string.dialogue_rickandmorty_to_morphling_1),
            context.getString(R.string.dialogue_rickandmorty_to_morphling_2),
            context.getString(R.string.dialogue_rickandmorty_to_naga_siren),
            context.getString(R.string.dialogue_rickandmorty_to_natures_prophet),
            context.getString(R.string.dialogue_rickandmorty_to_necrophos),
            context.getString(R.string.dialogue_rickandmorty_to_nyx),
            context.getString(R.string.dialogue_rickandmorty_to_ogre_1),
            context.getString(R.string.dialogue_rickandmorty_to_ogre_2),
            context.getString(R.string.dialogue_rickandmorty_to_outworld_devourer),
            context.getString(R.string.dialogue_rickandmorty_to_phantom_assassin),
            context.getString(R.string.dialogue_rickandmorty_to_phoenix),
            context.getString(R.string.dialogue_rickandmorty_to_puck),
            context.getString(R.string.dialogue_rickandmorty_to_pudge),
            context.getString(R.string.dialogue_rickandmorty_to_pugna),
            context.getString(R.string.dialogue_rickandmorty_to_queen_of_pain),
            context.getString(R.string.dialogue_rickandmorty_to_razor),
            context.getString(R.string.dialogue_rickandmorty_to_riki),
            context.getString(R.string.dialogue_rickandmorty_to_rubick),
            context.getString(R.string.dialogue_rickandmorty_to_sand_king),
            context.getString(R.string.dialogue_rickandmorty_to_shadow_demon),
            context.getString(R.string.dialogue_rickandmorty_to_shadow_fiend),
            context.getString(R.string.dialogue_rickandmorty_to_shadow_shaman),
            context.getString(R.string.dialogue_rickandmorty_to_silencer),
            context.getString(R.string.dialogue_rickandmorty_to_skeletons),
            context.getString(R.string.dialogue_rickandmorty_to_skywrath_1),
            context.getString(R.string.dialogue_rickandmorty_to_skywrath_2),
            context.getString(R.string.dialogue_rickandmorty_to_slardar),
            context.getString(R.string.dialogue_rickandmorty_to_slark_1),
            context.getString(R.string.dialogue_rickandmorty_to_slark_2),
            context.getString(R.string.dialogue_rickandmorty_to_slark_3),
            context.getString(R.string.dialogue_rickandmorty_to_sniper),
            context.getString(R.string.dialogue_rickandmorty_to_spectre),
            context.getString(R.string.dialogue_rickandmorty_to_spirit_breaker),
            context.getString(R.string.dialogue_rickandmorty_to_storm_spirit),
            context.getString(R.string.dialogue_rickandmorty_to_sven),
            context.getString(R.string.dialogue_rickandmorty_to_techies_1),
            context.getString(R.string.dialogue_rickandmorty_to_techies_2),
            context.getString(R.string.dialogue_rickandmorty_to_terrorblade),
            context.getString(R.string.dialogue_rickandmorty_to_tidehunter_1),
            context.getString(R.string.dialogue_rickandmorty_to_tidehunter_2),
            context.getString(R.string.dialogue_rickandmorty_to_tinker_1),
            context.getString(R.string.dialogue_rickandmorty_to_tinker_2),
            context.getString(R.string.dialogue_rickandmorty_to_tinker_3),
            context.getString(R.string.dialogue_rickandmorty_to_tiny),
            context.getString(R.string.dialogue_rickandmorty_to_treant_1),
            context.getString(R.string.dialogue_rickandmorty_to_treant_2),
            context.getString(R.string.dialogue_rickandmorty_to_treant_3),
            context.getString(R.string.dialogue_rickandmorty_to_troll_warlord),
            context.getString(R.string.dialogue_rickandmorty_to_tusk),
            context.getString(R.string.dialogue_rickandmorty_to_underlord),
            context.getString(R.string.dialogue_rickandmorty_to_undying_1),
            context.getString(R.string.dialogue_rickandmorty_to_undying_2),
            context.getString(R.string.dialogue_rickandmorty_to_ursa),
            context.getString(R.string.dialogue_rickandmorty_to_vengeful_spirit),
            context.getString(R.string.dialogue_rickandmorty_to_venomancer),
            context.getString(R.string.dialogue_rickandmorty_to_viper),
            context.getString(R.string.dialogue_rickandmorty_to_visage),
            context.getString(R.string.dialogue_rickandmorty_to_warlock),
            context.getString(R.string.dialogue_rickandmorty_to_weaver),
            context.getString(R.string.dialogue_rickandmorty_to_winter_wyvern),
            context.getString(R.string.dialogue_rickandmorty_to_witch_doctor),
            context.getString(R.string.dialogue_rickandmorty_to_wizards),
            context.getString(R.string.dialogue_rickandmorty_to_wraith_king),
            context.getString(R.string.dialogue_rickandmorty_to_zeus)
    )

    val rickandmorty_sound_res_Game = arrayListOf(
            R.raw.dialogue_rickandmorty_10_seconds_to_pick,
            R.raw.dialogue_rickandmorty_1_v_1_get_a_room,
            R.raw.dialogue_rickandmorty_1_v_1_tough_guy,
            R.raw.dialogue_rickandmorty_about_to_start,
            R.raw.dialogue_rickandmorty_bad_pick_1,
            R.raw.dialogue_rickandmorty_bad_pick_2,
            R.raw.dialogue_rickandmorty_bottom_barracks_rekt,
            R.raw.dialogue_rickandmorty_bottom_tower,
            R.raw.dialogue_rickandmorty_choose_hero_dont_rush,
            R.raw.dialogue_rickandmorty_choose_your_hero,
            R.raw.dialogue_rickandmorty_defeat_1,
            R.raw.dialogue_rickandmorty_defeat_2,
            R.raw.dialogue_rickandmorty_dire_pick_good,
            R.raw.dialogue_rickandmorty_disconnect_1,
            R.raw.dialogue_rickandmorty_disconnect_2,
            R.raw.dialogue_rickandmorty_disconnect_3,
            R.raw.dialogue_rickandmorty_disconnect_4,
            R.raw.dialogue_rickandmorty_dominating,
            R.raw.dialogue_rickandmorty_dont_pick,
            R.raw.dialogue_rickandmorty_enemy_megacreeps,
            R.raw.dialogue_rickandmorty_enemy_team_wipe,
            R.raw.dialogue_rickandmorty_first_blood,
            R.raw.dialogue_rickandmorty_first_blood_salty,
            R.raw.dialogue_rickandmorty_godlike,
            R.raw.dialogue_rickandmorty_good_game,
            R.raw.dialogue_rickandmorty_holy_shit,
            R.raw.dialogue_rickandmorty_holy_shit_2,
            R.raw.dialogue_rickandmorty_killing_spree,
            R.raw.dialogue_rickandmorty_megacreeps,
            R.raw.dialogue_rickandmorty_megakill,
            R.raw.dialogue_rickandmorty_middle_barracks_rekt,
            R.raw.dialogue_rickandmorty_middle_tower,
            R.raw.dialogue_rickandmorty_mid_only,
            R.raw.dialogue_rickandmorty_missing_bottom,
            R.raw.dialogue_rickandmorty_missing_middle,
            R.raw.dialogue_rickandmorty_missing_top,
            R.raw.dialogue_rickandmorty_monster_kill,
            R.raw.dialogue_rickandmorty_pick_right_radiant,
            R.raw.dialogue_rickandmorty_rampage,
            R.raw.dialogue_rickandmorty_rampage_2,
            R.raw.dialogue_rickandmorty_reconnected,
            R.raw.dialogue_rickandmorty_roshan_dire,
            R.raw.dialogue_rickandmorty_roshan_radiant,
            R.raw.dialogue_rickandmorty_team_wipe,
            R.raw.dialogue_rickandmorty_they_picked_this_mode,
            R.raw.dialogue_rickandmorty_top_barracks_rekt,
            R.raw.dialogue_rickandmorty_top_tower,
            R.raw.dialogue_rickandmorty_ultra_kill,
            R.raw.dialogue_rickandmorty_unstoppable,
            R.raw.dialogue_rickandmorty_victory_dire,
            R.raw.dialogue_rickandmorty_victory_radiant,
            R.raw.dialogue_rickandmorty_wicked_sick,
            R.raw.dialogue_rickandmorty_your_pick_bro,
            R.raw.dialogue_rickandmorty_your_pick_hello
    )

    val rickandmorty_sound_titles_Game = arrayListOf<String>(
            context.getString(R.string.dialogue_rickandmorty_10_seconds_to_pick),
            context.getString(R.string.dialogue_rickandmorty_1_v_1_get_a_room),
            context.getString(R.string.dialogue_rickandmorty_1_v_1_tough_guy),
            context.getString(R.string.dialogue_rickandmorty_about_to_start),
            context.getString(R.string.dialogue_rickandmorty_bad_pick_1),
            context.getString(R.string.dialogue_rickandmorty_bad_pick_2),
            context.getString(R.string.dialogue_rickandmorty_bottom_barracks_rekt),
            context.getString(R.string.dialogue_rickandmorty_bottom_tower),
            context.getString(R.string.dialogue_rickandmorty_choose_hero_dont_rush),
            context.getString(R.string.dialogue_rickandmorty_choose_your_hero),
            context.getString(R.string.dialogue_rickandmorty_defeat_1),
            context.getString(R.string.dialogue_rickandmorty_defeat_2),
            context.getString(R.string.dialogue_rickandmorty_dire_pick_good),
            context.getString(R.string.dialogue_rickandmorty_disconnect_1),
            context.getString(R.string.dialogue_rickandmorty_disconnect_2),
            context.getString(R.string.dialogue_rickandmorty_disconnect_3),
            context.getString(R.string.dialogue_rickandmorty_disconnect_4),
            context.getString(R.string.dialogue_rickandmorty_dominating),
            context.getString(R.string.dialogue_rickandmorty_dont_pick),
            context.getString(R.string.dialogue_rickandmorty_enemy_megacreeps),
            context.getString(R.string.dialogue_rickandmorty_enemy_team_wipe),
            context.getString(R.string.dialogue_rickandmorty_first_blood),
            context.getString(R.string.dialogue_rickandmorty_first_blood_salty),
            context.getString(R.string.dialogue_rickandmorty_godlike),
            context.getString(R.string.dialogue_rickandmorty_good_game),
            context.getString(R.string.dialogue_rickandmorty_holy_shit),
            context.getString(R.string.dialogue_rickandmorty_holy_shit_2),
            context.getString(R.string.dialogue_rickandmorty_killing_spree),
            context.getString(R.string.dialogue_rickandmorty_megacreeps),
            context.getString(R.string.dialogue_rickandmorty_megakill),
            context.getString(R.string.dialogue_rickandmorty_middle_barracks_rekt),
            context.getString(R.string.dialogue_rickandmorty_middle_tower),
            context.getString(R.string.dialogue_rickandmorty_mid_only),
            context.getString(R.string.dialogue_rickandmorty_missing_bottom),
            context.getString(R.string.dialogue_rickandmorty_missing_middle),
            context.getString(R.string.dialogue_rickandmorty_missing_top),
            context.getString(R.string.dialogue_rickandmorty_monster_kill),
            context.getString(R.string.dialogue_rickandmorty_pick_right_radiant),
            context.getString(R.string.dialogue_rickandmorty_rampage),
            context.getString(R.string.dialogue_rickandmorty_rampage_2),
            context.getString(R.string.dialogue_rickandmorty_reconnected),
            context.getString(R.string.dialogue_rickandmorty_roshan_dire),
            context.getString(R.string.dialogue_rickandmorty_roshan_radiant),
            context.getString(R.string.dialogue_rickandmorty_team_wipe),
            context.getString(R.string.dialogue_rickandmorty_they_picked_this_mode),
            context.getString(R.string.dialogue_rickandmorty_top_barracks_rekt),
            context.getString(R.string.dialogue_rickandmorty_top_tower),
            context.getString(R.string.dialogue_rickandmorty_ultra_kill),
            context.getString(R.string.dialogue_rickandmorty_unstoppable),
            context.getString(R.string.dialogue_rickandmorty_victory_dire),
            context.getString(R.string.dialogue_rickandmorty_victory_radiant),
            context.getString(R.string.dialogue_rickandmorty_wicked_sick),
            context.getString(R.string.dialogue_rickandmorty_your_pick_bro),
            context.getString(R.string.dialogue_rickandmorty_your_pick_hello)
    )

    val rickandmorty_sound_res_Misc = arrayListOf(
            R.raw.dialogue_rickandmorty_blonk_blonk_song,
            R.raw.dialogue_rickandmorty_can_we_wrap_this_up,
            R.raw.dialogue_rickandmorty_celebration,
            R.raw.dialogue_rickandmorty_close_call,
            R.raw.dialogue_rickandmorty_confusing_and_horrible,
            R.raw.dialogue_rickandmorty_defenestration_of_those_patients,
            R.raw.dialogue_rickandmorty_demonstration_of_the_ants,
            R.raw.dialogue_rickandmorty_die_for_real,
            R.raw.dialogue_rickandmorty_dont_even_care,
            R.raw.dialogue_rickandmorty_goodness_gracious,
            R.raw.dialogue_rickandmorty_gotta_do_something,
            R.raw.dialogue_rickandmorty_happy,
            R.raw.dialogue_rickandmorty_im_mr_meeseeks,
            R.raw.dialogue_rickandmorty_its_on_baby,
            R.raw.dialogue_rickandmorty_i_love_it_morty,
            R.raw.dialogue_rickandmorty_just_horrible,
            R.raw.dialogue_rickandmorty_least_played_unlike_summer,
            R.raw.dialogue_rickandmorty_live_streaming,
            R.raw.dialogue_rickandmorty_not_good,
            R.raw.dialogue_rickandmorty_oh_boy,
            R.raw.dialogue_rickandmorty_ones_and_zeros,
            R.raw.dialogue_rickandmorty_pisses_me_off,
            R.raw.dialogue_rickandmorty_pretty_lame,
            R.raw.dialogue_rickandmorty_real_trouble,
            R.raw.dialogue_rickandmorty_riggity_riggity_rekt_son,
            R.raw.dialogue_rickandmorty_screw_that_person,
            R.raw.dialogue_rickandmorty_simulated_world,
            R.raw.dialogue_rickandmorty_single_draft_with_lemonade,
            R.raw.dialogue_rickandmorty_sleepy,
            R.raw.dialogue_rickandmorty_thats_rickdiculous,
            R.raw.dialogue_rickandmorty_things_are_getting_dire,
            R.raw.dialogue_rickandmorty_too_hot_for,
            R.raw.dialogue_rickandmorty_totes_mlotes_dawg,
            R.raw.dialogue_rickandmorty_vitamin_d,
            R.raw.dialogue_rickandmorty_whatup_my_glip_glops,
            R.raw.dialogue_rickandmorty_what_a_mess,
            R.raw.dialogue_rickandmorty_what_does_dota_stand_for,
            R.raw.dialogue_rickandmorty_whooped,
            R.raw.dialogue_rickandmorty_wubba_lubba_dub_dub,
            R.raw.dialogue_rickandmorty_you_just_killed_it
    )

    val rickandmorty_sound_titles_Misc = arrayListOf<String>(
            context.getString(R.string.dialogue_rickandmorty_blonk_blonk_song),
            context.getString(R.string.dialogue_rickandmorty_can_we_wrap_this_up),
            context.getString(R.string.dialogue_rickandmorty_celebration),
            context.getString(R.string.dialogue_rickandmorty_close_call),
            context.getString(R.string.dialogue_rickandmorty_confusing_and_horrible),
            context.getString(R.string.dialogue_rickandmorty_defenestration_of_those_patients),
            context.getString(R.string.dialogue_rickandmorty_demonstration_of_the_ants),
            context.getString(R.string.dialogue_rickandmorty_die_for_real),
            context.getString(R.string.dialogue_rickandmorty_dont_even_care),
            context.getString(R.string.dialogue_rickandmorty_goodness_gracious),
            context.getString(R.string.dialogue_rickandmorty_gotta_do_something),
            context.getString(R.string.dialogue_rickandmorty_happy),
            context.getString(R.string.dialogue_rickandmorty_im_mr_meeseeks),
            context.getString(R.string.dialogue_rickandmorty_its_on_baby),
            context.getString(R.string.dialogue_rickandmorty_i_love_it_morty),
            context.getString(R.string.dialogue_rickandmorty_just_horrible),
            context.getString(R.string.dialogue_rickandmorty_least_played_unlike_summer),
            context.getString(R.string.dialogue_rickandmorty_live_streaming),
            context.getString(R.string.dialogue_rickandmorty_not_good),
            context.getString(R.string.dialogue_rickandmorty_oh_boy),
            context.getString(R.string.dialogue_rickandmorty_ones_and_zeros),
            context.getString(R.string.dialogue_rickandmorty_pisses_me_off),
            context.getString(R.string.dialogue_rickandmorty_pretty_lame),
            context.getString(R.string.dialogue_rickandmorty_real_trouble),
            context.getString(R.string.dialogue_rickandmorty_riggity_riggity_rekt_son),
            context.getString(R.string.dialogue_rickandmorty_screw_that_person),
            context.getString(R.string.dialogue_rickandmorty_simulated_world),
            context.getString(R.string.dialogue_rickandmorty_single_draft_with_lemonade),
            context.getString(R.string.dialogue_rickandmorty_sleepy),
            context.getString(R.string.dialogue_rickandmorty_thats_rickdiculous),
            context.getString(R.string.dialogue_rickandmorty_things_are_getting_dire),
            context.getString(R.string.dialogue_rickandmorty_too_hot_for),
            context.getString(R.string.dialogue_rickandmorty_totes_mlotes_dawg),
            context.getString(R.string.dialogue_rickandmorty_vitamin_d),
            context.getString(R.string.dialogue_rickandmorty_whatup_my_glip_glops),
            context.getString(R.string.dialogue_rickandmorty_what_a_mess),
            context.getString(R.string.dialogue_rickandmorty_what_does_dota_stand_for),
            context.getString(R.string.dialogue_rickandmorty_whooped),
            context.getString(R.string.dialogue_rickandmorty_wubba_lubba_dub_dub),
            context.getString(R.string.dialogue_rickandmorty_you_just_killed_it)
    )

    // STRENGTH HEROES

    // Abaddon
    val board_header_abaddon = R.drawable.header_abaddon
    val abaddon_sound_res_Abilities = arrayListOf(
            R.raw.dialogue_abaddon_aphotic_shield,
            R.raw.dialogue_abaddon_a_shield_impenetrable,
            R.raw.dialogue_abaddon_blessed_of_avernus,
            R.raw.dialogue_abaddon_by_what_right_do_you_tread_here,
            R.raw.dialogue_abaddon_coil_keep_you,
            R.raw.dialogue_abaddon_coil_of_life,
            R.raw.dialogue_abaddon_come_at_me,
            R.raw.dialogue_abaddon_death_for_you_life_for_me,
            R.raw.dialogue_abaddon_down_with_you,
            R.raw.dialogue_abaddon_do_that_again,
            R.raw.dialogue_abaddon_here_friends,
            R.raw.dialogue_abaddon_ill_take_your_worst,
            R.raw.dialogue_abaddon_its_not_time_yet,
            R.raw.dialogue_abaddon_not_enough_mana,
            R.raw.dialogue_abaddon_shielded,
            R.raw.dialogue_abaddon_take_shelter,
            R.raw.dialogue_abaddon_that_harms_me_not,
            R.raw.dialogue_abaddon_the_coil_of_death_ensnares,
            R.raw.dialogue_abaddon_the_eyes_of_mist_have_seen_you
    )

    val abaddon_sound_titles_Abilities = arrayListOf<String>(
            context.getString(R.string.dialogue_abaddon_aphotic_shield),
            context.getString(R.string.dialogue_abaddon_a_shield_impenetrable),
            context.getString(R.string.dialogue_abaddon_blessed_of_avernus),
            context.getString(R.string.dialogue_abaddon_by_what_right_do_you_tread_here),
            context.getString(R.string.dialogue_abaddon_coil_keep_you),
            context.getString(R.string.dialogue_abaddon_coil_of_life),
            context.getString(R.string.dialogue_abaddon_come_at_me),
            context.getString(R.string.dialogue_abaddon_death_for_you_life_for_me),
            context.getString(R.string.dialogue_abaddon_down_with_you),
            context.getString(R.string.dialogue_abaddon_do_that_again),
            context.getString(R.string.dialogue_abaddon_here_friends),
            context.getString(R.string.dialogue_abaddon_ill_take_your_worst),
            context.getString(R.string.dialogue_abaddon_its_not_time_yet),
            context.getString(R.string.dialogue_abaddon_not_enough_mana),
            context.getString(R.string.dialogue_abaddon_shielded),
            context.getString(R.string.dialogue_abaddon_take_shelter),
            context.getString(R.string.dialogue_abaddon_that_harms_me_not),
            context.getString(R.string.dialogue_abaddon_the_coil_of_death_ensnares),
            context.getString(R.string.dialogue_abaddon_the_eyes_of_mist_have_seen_you)
    )

    val abaddon_sound_res_Attacks = arrayListOf(
            R.raw.dialogue_abaddon_follow_me,
            R.raw.dialogue_abaddon_im_under_attack,
            R.raw.dialogue_abaddon_it_ends,
            R.raw.dialogue_abaddon_run_them_down,
            R.raw.dialogue_abaddon_submit,
            R.raw.dialogue_abaddon_to_the_foe,
            R.raw.dialogue_abaddon_to_the_fray,
            R.raw.dialogue_abaddon_yes,
            R.raw.dialogue_abaddon_your_fate_was_foreshadowed_in_the_mist,
            R.raw.dialogue_abaddon_you_have_called_death_upon_yourself
    )

    val abaddon_sound_titles_Attacks = arrayListOf<String>(
            context.getString(R.string.dialogue_abaddon_follow_me),
            context.getString(R.string.dialogue_abaddon_im_under_attack),
            context.getString(R.string.dialogue_abaddon_it_ends),
            context.getString(R.string.dialogue_abaddon_run_them_down),
            context.getString(R.string.dialogue_abaddon_submit),
            context.getString(R.string.dialogue_abaddon_to_the_foe),
            context.getString(R.string.dialogue_abaddon_to_the_fray),
            context.getString(R.string.dialogue_abaddon_yes),
            context.getString(R.string.dialogue_abaddon_your_fate_was_foreshadowed_in_the_mist),
            context.getString(R.string.dialogue_abaddon_you_have_called_death_upon_yourself)
    )
    val abaddon_sound_res_Hero_Related = arrayListOf(
            R.raw.dialogue_abaddon_a_noble_rebirth,
            R.raw.dialogue_abaddon_drink_deep_of_the_mist_as_it_turns_to_black,
            R.raw.dialogue_abaddon_killing_axe,
            R.raw.dialogue_abaddon_killing_bane,
            R.raw.dialogue_abaddon_killing_bloodseeker,
            R.raw.dialogue_abaddon_killing_death_prophet,
            R.raw.dialogue_abaddon_killing_elder_titan,
            R.raw.dialogue_abaddon_killing_ember_spirit,
            R.raw.dialogue_abaddon_killing_legion_commander,
            R.raw.dialogue_abaddon_killing_lion,
            R.raw.dialogue_abaddon_killing_necrophos,
            R.raw.dialogue_abaddon_killing_nyx_assassin,
            R.raw.dialogue_abaddon_killing_phoenix,
            R.raw.dialogue_abaddon_killing_shadow_shaman,
            R.raw.dialogue_abaddon_killing_silencer,
            R.raw.dialogue_abaddon_killing_skywrath_mage,
            R.raw.dialogue_abaddon_killing_techies,
            R.raw.dialogue_abaddon_killing_underlord,
            R.raw.dialogue_abaddon_killing_winter_wyvern,
            R.raw.dialogue_abaddon_meeting_arc_warden,
            R.raw.dialogue_abaddon_meeting_axe,
            R.raw.dialogue_abaddon_meeting_bounty_hunter,
            R.raw.dialogue_abaddon_meeting_dazzle,
            R.raw.dialogue_abaddon_meeting_morphling,
            R.raw.dialogue_abaddon_meeting_phantom_assassin,
            R.raw.dialogue_abaddon_meeting_sven,
            R.raw.dialogue_abaddon_meeting_techies,
            R.raw.dialogue_abaddon_meeting_terrorblade,
            R.raw.dialogue_abaddon_meeting_tiny,
            R.raw.dialogue_abaddon_meeting_weaver,
            R.raw.dialogue_abaddon_no
    )

    val abaddon_sound_titles_Hero_Related = arrayListOf<String>(
            context.getString(R.string.dialogue_abaddon_a_noble_rebirth),
            context.getString(R.string.dialogue_abaddon_drink_deep_of_the_mist_as_it_turns_to_black),
            context.getString(R.string.dialogue_abaddon_killing_axe),
            context.getString(R.string.dialogue_abaddon_killing_bane),
            context.getString(R.string.dialogue_abaddon_killing_bloodseeker),
            context.getString(R.string.dialogue_abaddon_killing_death_prophet),
            context.getString(R.string.dialogue_abaddon_killing_elder_titan),
            context.getString(R.string.dialogue_abaddon_killing_ember_spirit),
            context.getString(R.string.dialogue_abaddon_killing_legion_commander),
            context.getString(R.string.dialogue_abaddon_killing_lion),
            context.getString(R.string.dialogue_abaddon_killing_necrophos),
            context.getString(R.string.dialogue_abaddon_killing_nyx_assassin),
            context.getString(R.string.dialogue_abaddon_killing_phoenix),
            context.getString(R.string.dialogue_abaddon_killing_shadow_shaman),
            context.getString(R.string.dialogue_abaddon_killing_silencer),
            context.getString(R.string.dialogue_abaddon_killing_skywrath_mage),
            context.getString(R.string.dialogue_abaddon_killing_techies),
            context.getString(R.string.dialogue_abaddon_killing_underlord),
            context.getString(R.string.dialogue_abaddon_killing_winter_wyvern),
            context.getString(R.string.dialogue_abaddon_meeting_arc_warden),
            context.getString(R.string.dialogue_abaddon_meeting_axe),
            context.getString(R.string.dialogue_abaddon_meeting_bounty_hunter),
            context.getString(R.string.dialogue_abaddon_meeting_dazzle),
            context.getString(R.string.dialogue_abaddon_meeting_morphling),
            context.getString(R.string.dialogue_abaddon_meeting_phantom_assassin),
            context.getString(R.string.dialogue_abaddon_meeting_sven),
            context.getString(R.string.dialogue_abaddon_meeting_techies),
            context.getString(R.string.dialogue_abaddon_meeting_terrorblade),
            context.getString(R.string.dialogue_abaddon_meeting_tiny),
            context.getString(R.string.dialogue_abaddon_meeting_weaver),
            context.getString(R.string.dialogue_abaddon_no)
    )
    val abaddon_sound_res_Items = arrayListOf(
            R.raw.dialogue_abaddon_ah_scepter,
            R.raw.dialogue_abaddon_a_noble_and_lordly_scepter,
            R.raw.dialogue_abaddon_blink_and_youll_be_missed,
            R.raw.dialogue_abaddon_immortality,
            R.raw.dialogue_abaddon_time_will_tell
    )

    val abaddon_sound_titles_Items = arrayListOf<String>(
            context.getString(R.string.dialogue_abaddon_ah_scepter),
            context.getString(R.string.dialogue_abaddon_a_noble_and_lordly_scepter),
            context.getString(R.string.dialogue_abaddon_blink_and_youll_be_missed),
            context.getString(R.string.dialogue_abaddon_immortality),
            context.getString(R.string.dialogue_abaddon_time_will_tell)
    )
    val abaddon_sound_res_Misc = arrayListOf(
            R.raw.dialogue_abaddon_ha_ha_ha,
            R.raw.dialogue_abaddon_shizzy_wizard,
            R.raw.dialogue_abaddon_with_gratitude,
            R.raw.dialogue_abaddon_you_have_my_thanks
    )

    val abaddon_sound_titles_Misc = arrayListOf<String>(
            context.getString(R.string.dialogue_abaddon_ha_ha_ha),
            context.getString(R.string.dialogue_abaddon_shizzy_wizard),
            context.getString(R.string.dialogue_abaddon_with_gratitude),
            context.getString(R.string.dialogue_abaddon_you_have_my_thanks)
    )

    // Alchemist
    val board_header_alchemist = R.drawable.header_alchemist
    val alchemist_sound_res_Abilities = arrayListOf(
            R.raw.dialogue_alchemist_acid_in_the_hole,
            R.raw.dialogue_alchemist_cocktails_for_five,
            R.raw.dialogue_alchemist_do_not_go_there,
            R.raw.dialogue_alchemist_duck,
            R.raw.dialogue_alchemist_everythings_better_with_scepter,
            R.raw.dialogue_alchemist_fore,
            R.raw.dialogue_alchemist_ha_ha_sic_em,
            R.raw.dialogue_alchemist_hey_everybody,
            R.raw.dialogue_alchemist_hold_your_nose,
            R.raw.dialogue_alchemist_incoming,
            R.raw.dialogue_alchemist_its_not_time_yet,
            R.raw.dialogue_alchemist_i_cant_believe_im_seeing_this_with_my_own_eyes,
            R.raw.dialogue_alchemist_look_out,
            R.raw.dialogue_alchemist_look_whats_cookin,
            R.raw.dialogue_alchemist_not_enough_mana,
            R.raw.dialogue_alchemist_shaken_and_stirred,
            R.raw.dialogue_alchemist_that_was_a_close_one,
            R.raw.dialogue_alchemist_thisll_eat_up_your_armor,
            R.raw.dialogue_alchemist_throw_the_damn_thing,
            R.raw.dialogue_alchemist_toxic_spill,
            R.raw.dialogue_alchemist_watch_your_head,
            R.raw.dialogue_alchemist_we_got_something_special_for_you,
            R.raw.dialogue_alchemist_what_the,
            R.raw.dialogue_alchemist_whoa_whoa_whoa_whoa
    )

    val alchemist_sound_titles_Abilities = arrayListOf<String>(
            context.getString(R.string.dialogue_alchemist_acid_in_the_hole),
            context.getString(R.string.dialogue_alchemist_cocktails_for_five),
            context.getString(R.string.dialogue_alchemist_do_not_go_there),
            context.getString(R.string.dialogue_alchemist_duck),
            context.getString(R.string.dialogue_alchemist_everythings_better_with_scepter),
            context.getString(R.string.dialogue_alchemist_fore),
            context.getString(R.string.dialogue_alchemist_ha_ha_sic_em),
            context.getString(R.string.dialogue_alchemist_hey_everybody),
            context.getString(R.string.dialogue_alchemist_hold_your_nose),
            context.getString(R.string.dialogue_alchemist_incoming),
            context.getString(R.string.dialogue_alchemist_its_not_time_yet),
            context.getString(R.string.dialogue_alchemist_i_cant_believe_im_seeing_this_with_my_own_eyes),
            context.getString(R.string.dialogue_alchemist_look_out),
            context.getString(R.string.dialogue_alchemist_look_whats_cookin),
            context.getString(R.string.dialogue_alchemist_not_enough_mana),
            context.getString(R.string.dialogue_alchemist_shaken_and_stirred),
            context.getString(R.string.dialogue_alchemist_that_was_a_close_one),
            context.getString(R.string.dialogue_alchemist_thisll_eat_up_your_armor),
            context.getString(R.string.dialogue_alchemist_throw_the_damn_thing),
            context.getString(R.string.dialogue_alchemist_toxic_spill),
            context.getString(R.string.dialogue_alchemist_watch_your_head),
            context.getString(R.string.dialogue_alchemist_we_got_something_special_for_you),
            context.getString(R.string.dialogue_alchemist_what_the),
            context.getString(R.string.dialogue_alchemist_whoa_whoa_whoa_whoa)
    )
    val alchemist_sound_res_Attacks = arrayListOf(
            R.raw.dialogue_alchemist_aaand_were_off,
            R.raw.dialogue_alchemist_alchemist,
            R.raw.dialogue_alchemist_alchemy_is_the_future,
            R.raw.dialogue_alchemist_alright_already,
            R.raw.dialogue_alchemist_candy_from_a_baby,
            R.raw.dialogue_alchemist_decanting,
            R.raw.dialogue_alchemist_easy_now_this_stuff_is_explosive,
            R.raw.dialogue_alchemist_formula_racing,
            R.raw.dialogue_alchemist_for_the_boss,
            R.raw.dialogue_alchemist_giddy_up,
            R.raw.dialogue_alchemist_gimme_gimme,
            R.raw.dialogue_alchemist_go_go_go,
            R.raw.dialogue_alchemist_greed_is_good,
            R.raw.dialogue_alchemist_here_we_come,
            R.raw.dialogue_alchemist_im_feeling_punchy,
            R.raw.dialogue_alchemist_im_the_brains_and_im_the_brawn,
            R.raw.dialogue_alchemist_mixing_it_up,
            R.raw.dialogue_alchemist_now_were_cookin,
            R.raw.dialogue_alchemist_okey_dokey,
            R.raw.dialogue_alchemist_pour_it_on,
            R.raw.dialogue_alchemist_sounds_like_a_plan,
            R.raw.dialogue_alchemist_thataway,
            R.raw.dialogue_alchemist_tiptoe_now_youre_shaking_my_brew,
            R.raw.dialogue_alchemist_weve_got_pretty_good_chemistry,
            R.raw.dialogue_alchemist_yeah_im_here,
            R.raw.dialogue_alchemist_yes,
            R.raw.dialogue_alchemist_youre_the_boss,
            R.raw.dialogue_alchemist_you_got_it
    )
    val alchemist_sound_titles_Attacks = arrayListOf<String>(
            context.getString(R.string.dialogue_alchemist_aaand_were_off),
            context.getString(R.string.dialogue_alchemist_alchemist),
            context.getString(R.string.dialogue_alchemist_alchemy_is_the_future),
            context.getString(R.string.dialogue_alchemist_alright_already),
            context.getString(R.string.dialogue_alchemist_candy_from_a_baby),
            context.getString(R.string.dialogue_alchemist_decanting),
            context.getString(R.string.dialogue_alchemist_easy_now_this_stuff_is_explosive),
            context.getString(R.string.dialogue_alchemist_formula_racing),
            context.getString(R.string.dialogue_alchemist_for_the_boss),
            context.getString(R.string.dialogue_alchemist_giddy_up),
            context.getString(R.string.dialogue_alchemist_gimme_gimme),
            context.getString(R.string.dialogue_alchemist_go_go_go),
            context.getString(R.string.dialogue_alchemist_greed_is_good),
            context.getString(R.string.dialogue_alchemist_here_we_come),
            context.getString(R.string.dialogue_alchemist_im_feeling_punchy),
            context.getString(R.string.dialogue_alchemist_im_the_brains_and_im_the_brawn),
            context.getString(R.string.dialogue_alchemist_mixing_it_up),
            context.getString(R.string.dialogue_alchemist_now_were_cookin),
            context.getString(R.string.dialogue_alchemist_okey_dokey),
            context.getString(R.string.dialogue_alchemist_pour_it_on),
            context.getString(R.string.dialogue_alchemist_sounds_like_a_plan),
            context.getString(R.string.dialogue_alchemist_thataway),
            context.getString(R.string.dialogue_alchemist_tiptoe_now_youre_shaking_my_brew),
            context.getString(R.string.dialogue_alchemist_weve_got_pretty_good_chemistry),
            context.getString(R.string.dialogue_alchemist_yeah_im_here),
            context.getString(R.string.dialogue_alchemist_yes),
            context.getString(R.string.dialogue_alchemist_youre_the_boss),
            context.getString(R.string.dialogue_alchemist_you_got_it)
    )
    val alchemist_sound_res_Hero_Related = arrayListOf(
            R.raw.dialogue_alchemist_aw_i_was_just_getting_started,
            R.raw.dialogue_alchemist_failure_is_just_another_kind_of_success,
            R.raw.dialogue_alchemist_first_blood,
            R.raw.dialogue_alchemist_killing_ancient_apparition,
            R.raw.dialogue_alchemist_killing_axe,
            R.raw.dialogue_alchemist_killing_batrider,
            R.raw.dialogue_alchemist_killing_clinkz,
            R.raw.dialogue_alchemist_killing_clockwerk,
            R.raw.dialogue_alchemist_killing_doom,
            R.raw.dialogue_alchemist_killing_earthshaker,
            R.raw.dialogue_alchemist_killing_kunkka_two,
            R.raw.dialogue_alchemist_killing_kunkka,
            R.raw.dialogue_alchemist_killing_morphling,
            R.raw.dialogue_alchemist_killing_puck,
            R.raw.dialogue_alchemist_killing_pudge,
            R.raw.dialogue_alchemist_killing_pugna,
            R.raw.dialogue_alchemist_killing_slardar,
            R.raw.dialogue_alchemist_killing_sniper,
            R.raw.dialogue_alchemist_killing_spirit_breaker,
            R.raw.dialogue_alchemist_killing_wraith_king,
            R.raw.dialogue_alchemist_no,
            R.raw.dialogue_alchemist_thats_comedy_gold,
            R.raw.dialogue_alchemist_that_was_genius,
            R.raw.dialogue_alchemist_that_was_special_for_you,
            R.raw.dialogue_alchemist_well_be_right_back,
            R.raw.dialogue_alchemist_youre_melting_youre_melting_ha_ha
    )
    val alchemist_sound_titles_Hero_Related = arrayListOf<String>(
            context.getString(R.string.dialogue_alchemist_aw_i_was_just_getting_started),
            context.getString(R.string.dialogue_alchemist_failure_is_just_another_kind_of_success),
            context.getString(R.string.dialogue_alchemist_first_blood),
            context.getString(R.string.dialogue_alchemist_killing_ancient_apparition),
            context.getString(R.string.dialogue_alchemist_killing_axe),
            context.getString(R.string.dialogue_alchemist_killing_batrider),
            context.getString(R.string.dialogue_alchemist_killing_clinkz),
            context.getString(R.string.dialogue_alchemist_killing_clockwerk),
            context.getString(R.string.dialogue_alchemist_killing_doom),
            context.getString(R.string.dialogue_alchemist_killing_earthshaker),
            context.getString(R.string.dialogue_alchemist_killing_kunkka_two),
            context.getString(R.string.dialogue_alchemist_killing_kunkka),
            context.getString(R.string.dialogue_alchemist_killing_morphling),
            context.getString(R.string.dialogue_alchemist_killing_puck),
            context.getString(R.string.dialogue_alchemist_killing_pudge),
            context.getString(R.string.dialogue_alchemist_killing_pugna),
            context.getString(R.string.dialogue_alchemist_killing_slardar),
            context.getString(R.string.dialogue_alchemist_killing_sniper),
            context.getString(R.string.dialogue_alchemist_killing_spirit_breaker),
            context.getString(R.string.dialogue_alchemist_killing_wraith_king),
            context.getString(R.string.dialogue_alchemist_no),
            context.getString(R.string.dialogue_alchemist_thats_comedy_gold),
            context.getString(R.string.dialogue_alchemist_that_was_genius),
            context.getString(R.string.dialogue_alchemist_that_was_special_for_you),
            context.getString(R.string.dialogue_alchemist_well_be_right_back),
            context.getString(R.string.dialogue_alchemist_youre_melting_youre_melting_ha_ha)
    )
    val alchemist_sound_res_Items = arrayListOf(
            R.raw.dialogue_alchemist_blink_dagger_less_walking_is_good,
            R.raw.dialogue_alchemist_immortality,
            R.raw.dialogue_alchemist_is_it_a_back_brace,
            R.raw.dialogue_alchemist_oh_ho_scepter,
            R.raw.dialogue_alchemist_ooh,
            R.raw.dialogue_alchemist_run_buddy_run
    )
    val alchemist_sound_titles_Items = arrayListOf<String>(
            context.getString(R.string.dialogue_alchemist_blink_dagger_less_walking_is_good),
            context.getString(R.string.dialogue_alchemist_immortality),
            context.getString(R.string.dialogue_alchemist_is_it_a_back_brace),
            context.getString(R.string.dialogue_alchemist_oh_ho_scepter),
            context.getString(R.string.dialogue_alchemist_ooh),
            context.getString(R.string.dialogue_alchemist_run_buddy_run)
    )
    val alchemist_sound_res_Misc = arrayListOf(
            R.raw.dialogue_alchemist_hey_little_buddy_its_in_the_bag,
            R.raw.dialogue_alchemist_i_cant_feel_my_legs,
            R.raw.dialogue_alchemist_shizzy_wizard,
            R.raw.dialogue_alchemist_thanks,
            R.raw.dialogue_alchemist_we_owe_ya_one
    )

    val alchemist_sound_titles_Misc = arrayListOf<String>(
            context.getString(R.string.dialogue_alchemist_hey_little_buddy_its_in_the_bag),
            context.getString(R.string.dialogue_alchemist_i_cant_feel_my_legs),
            context.getString(R.string.dialogue_alchemist_shizzy_wizard),
            context.getString(R.string.dialogue_alchemist_thanks),
            context.getString(R.string.dialogue_alchemist_we_owe_ya_one)
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

    // Clockwerk
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
    val clinkz_sound_res_Abilities = arrayListOf(
            R.raw.dialogue_clinkz_be_my_armor,
            R.raw.dialogue_clinkz_death_in_trade,
            R.raw.dialogue_clinkz_fill_them_with_holes,
            R.raw.dialogue_clinkz_flames_hide_from_sight,
            R.raw.dialogue_clinkz_its_not_time_yet,
            R.raw.dialogue_clinkz_i_let_loose,
            R.raw.dialogue_clinkz_i_lighten_my_quiver,
            R.raw.dialogue_clinkz_i_walk_with_the_wind,
            R.raw.dialogue_clinkz_look_whos_back,
            R.raw.dialogue_clinkz_not_enough_mana,
            R.raw.dialogue_clinkz_pincushion,
            R.raw.dialogue_clinkz_thy_flesh_consumed,
            R.raw.dialogue_clinkz_unseen_flame,
            R.raw.dialogue_clinkz_what_words_cannot,
            R.raw.dialogue_clinkz_your_health_is_mine,
            R.raw.dialogue_clinkz_your_life_is_mine
    )

    val clinkz_sound_titles_Abilities = arrayListOf<String>(
            context.getString(R.string.dialogue_clinkz_be_my_armor),
            context.getString(R.string.dialogue_clinkz_death_in_trade),
            context.getString(R.string.dialogue_clinkz_fill_them_with_holes),
            context.getString(R.string.dialogue_clinkz_flames_hide_from_sight),
            context.getString(R.string.dialogue_clinkz_its_not_time_yet),
            context.getString(R.string.dialogue_clinkz_i_let_loose),
            context.getString(R.string.dialogue_clinkz_i_lighten_my_quiver),
            context.getString(R.string.dialogue_clinkz_i_walk_with_the_wind),
            context.getString(R.string.dialogue_clinkz_look_whos_back),
            context.getString(R.string.dialogue_clinkz_not_enough_mana),
            context.getString(R.string.dialogue_clinkz_pincushion),
            context.getString(R.string.dialogue_clinkz_thy_flesh_consumed),
            context.getString(R.string.dialogue_clinkz_unseen_flame),
            context.getString(R.string.dialogue_clinkz_what_words_cannot),
            context.getString(R.string.dialogue_clinkz_your_health_is_mine),
            context.getString(R.string.dialogue_clinkz_your_life_is_mine)
    )
    val clinkz_sound_res_Attacks = arrayListOf(
            R.raw.dialogue_clinkz_an_arrow_lights_my_way,
            R.raw.dialogue_clinkz_an_arrow_true,
            R.raw.dialogue_clinkz_attack,
            R.raw.dialogue_clinkz_a_bona_fide_victory,
            R.raw.dialogue_clinkz_battalion_of_bones,
            R.raw.dialogue_clinkz_better_to_run,
            R.raw.dialogue_clinkz_bullseye,
            R.raw.dialogue_clinkz_certainly,
            R.raw.dialogue_clinkz_clinkz,
            R.raw.dialogue_clinkz_clink_goes_my_bones,
            R.raw.dialogue_clinkz_compound_damage,
            R.raw.dialogue_clinkz_death_comes_for_you,
            R.raw.dialogue_clinkz_firing,
            R.raw.dialogue_clinkz_flesh_is_but_a_garment,
            R.raw.dialogue_clinkz_fly_true,
            R.raw.dialogue_clinkz_for_the_hoven_lands,
            R.raw.dialogue_clinkz_ill_see_you_burn,
            R.raw.dialogue_clinkz_indeed,
            R.raw.dialogue_clinkz_in_my_sights,
            R.raw.dialogue_clinkz_i_alight_to_battle,
            R.raw.dialogue_clinkz_i_am_clinkz,
            R.raw.dialogue_clinkz_i_fire_my_arrow,
            R.raw.dialogue_clinkz_i_swear_it,
            R.raw.dialogue_clinkz_let_fly,
            R.raw.dialogue_clinkz_light_my_way,
            R.raw.dialogue_clinkz_my_arrow_ends_you,
            R.raw.dialogue_clinkz_my_arrow_shall_find_its_target,
            R.raw.dialogue_clinkz_my_bones_outlive_me,
            R.raw.dialogue_clinkz_no,
            R.raw.dialogue_clinkz_none_quicker,
            R.raw.dialogue_clinkz_nooo,
            R.raw.dialogue_clinkz_notched_and_ready,
            R.raw.dialogue_clinkz_not_for_you,
            R.raw.dialogue_clinkz_no_tower_for_you,
            R.raw.dialogue_clinkz_on_target,
            R.raw.dialogue_clinkz_point_the_way,
            R.raw.dialogue_clinkz_quick_fire,
            R.raw.dialogue_clinkz_set_you_alight,
            R.raw.dialogue_clinkz_shot_dead,
            R.raw.dialogue_clinkz_straight_as_an_arrow,
            R.raw.dialogue_clinkz_straight_flight,
            R.raw.dialogue_clinkz_straight_shooter,
            R.raw.dialogue_clinkz_they_will_burn,
            R.raw.dialogue_clinkz_the_fire_of_war_is_set,
            R.raw.dialogue_clinkz_uh_uh,
            R.raw.dialogue_clinkz_warn_a_hundred,
            R.raw.dialogue_clinkz_where_to,
            R.raw.dialogue_clinkz_worthy_of_gold,
            R.raw.dialogue_clinkz_yes,
            R.raw.dialogue_clinkz_your_flesh_is_weak,
            R.raw.dialogue_clinkz_you_almost_had_it_too
    )

    val clinkz_sound_titles_Attacks = arrayListOf<String>(
            context.getString(R.string.dialogue_clinkz_an_arrow_lights_my_way),
            context.getString(R.string.dialogue_clinkz_an_arrow_true),
            context.getString(R.string.dialogue_clinkz_attack),
            context.getString(R.string.dialogue_clinkz_a_bona_fide_victory),
            context.getString(R.string.dialogue_clinkz_battalion_of_bones),
            context.getString(R.string.dialogue_clinkz_better_to_run),
            context.getString(R.string.dialogue_clinkz_bullseye),
            context.getString(R.string.dialogue_clinkz_certainly),
            context.getString(R.string.dialogue_clinkz_clinkz),
            context.getString(R.string.dialogue_clinkz_clink_goes_my_bones),
            context.getString(R.string.dialogue_clinkz_compound_damage),
            context.getString(R.string.dialogue_clinkz_death_comes_for_you),
            context.getString(R.string.dialogue_clinkz_firing),
            context.getString(R.string.dialogue_clinkz_flesh_is_but_a_garment),
            context.getString(R.string.dialogue_clinkz_fly_true),
            context.getString(R.string.dialogue_clinkz_for_the_hoven_lands),
            context.getString(R.string.dialogue_clinkz_ill_see_you_burn),
            context.getString(R.string.dialogue_clinkz_indeed),
            context.getString(R.string.dialogue_clinkz_in_my_sights),
            context.getString(R.string.dialogue_clinkz_i_alight_to_battle),
            context.getString(R.string.dialogue_clinkz_i_am_clinkz),
            context.getString(R.string.dialogue_clinkz_i_fire_my_arrow),
            context.getString(R.string.dialogue_clinkz_i_swear_it),
            context.getString(R.string.dialogue_clinkz_let_fly),
            context.getString(R.string.dialogue_clinkz_light_my_way),
            context.getString(R.string.dialogue_clinkz_my_arrow_ends_you),
            context.getString(R.string.dialogue_clinkz_my_arrow_shall_find_its_target),
            context.getString(R.string.dialogue_clinkz_my_bones_outlive_me),
            context.getString(R.string.dialogue_clinkz_no),
            context.getString(R.string.dialogue_clinkz_none_quicker),
            context.getString(R.string.dialogue_clinkz_nooo),
            context.getString(R.string.dialogue_clinkz_notched_and_ready),
            context.getString(R.string.dialogue_clinkz_not_for_you),
            context.getString(R.string.dialogue_clinkz_no_tower_for_you),
            context.getString(R.string.dialogue_clinkz_on_target),
            context.getString(R.string.dialogue_clinkz_point_the_way),
            context.getString(R.string.dialogue_clinkz_quick_fire),
            context.getString(R.string.dialogue_clinkz_set_you_alight),
            context.getString(R.string.dialogue_clinkz_shot_dead),
            context.getString(R.string.dialogue_clinkz_straight_as_an_arrow),
            context.getString(R.string.dialogue_clinkz_straight_flight),
            context.getString(R.string.dialogue_clinkz_straight_shooter),
            context.getString(R.string.dialogue_clinkz_they_will_burn),
            context.getString(R.string.dialogue_clinkz_the_fire_of_war_is_set),
            context.getString(R.string.dialogue_clinkz_uh_uh),
            context.getString(R.string.dialogue_clinkz_warn_a_hundred),
            context.getString(R.string.dialogue_clinkz_where_to),
            context.getString(R.string.dialogue_clinkz_worthy_of_gold),
            context.getString(R.string.dialogue_clinkz_yes),
            context.getString(R.string.dialogue_clinkz_your_flesh_is_weak),
            context.getString(R.string.dialogue_clinkz_you_almost_had_it_too)
    )
    val clinkz_sound_res_Hero_Related = arrayListOf(
    R.raw.dialogue_clinkz_ashes_to_ashes,
    R.raw.dialogue_clinkz_burned_you_down,
    R.raw.dialogue_clinkz_burn_them_down_together,
    R.raw.dialogue_clinkz_burn_your_body,
    R.raw.dialogue_clinkz_cremation_is_in_your_future,
    R.raw.dialogue_clinkz_even_the_dead_can_be_reborn,
    R.raw.dialogue_clinkz_fire_grows_hungrier,
    R.raw.dialogue_clinkz_first_blood,
    R.raw.dialogue_clinkz_for_the_king_mage,
    R.raw.dialogue_clinkz_gift_of_death,
    R.raw.dialogue_clinkz_i_plucked_your_life,
    R.raw.dialogue_clinkz_i_rise_from_the_cinders,
    R.raw.dialogue_clinkz_killing_ancient_apparition,
    R.raw.dialogue_clinkz_killing_batrider,
    R.raw.dialogue_clinkz_killing_crystal_maiden,
    R.raw.dialogue_clinkz_killing_doom,
    R.raw.dialogue_clinkz_killing_lich,
    R.raw.dialogue_clinkz_killing_lina,
    R.raw.dialogue_clinkz_killing_pudge,
    R.raw.dialogue_clinkz_killing_windranger,
    R.raw.dialogue_clinkz_meeting_drow_ranger,
    R.raw.dialogue_clinkz_meeting_jakiro,
    R.raw.dialogue_clinkz_meeting_lich,
    R.raw.dialogue_clinkz_meeting_lina,
    R.raw.dialogue_clinkz_meeting_pugna,
    R.raw.dialogue_clinkz_quench_my_arrows,
    R.raw.dialogue_clinkz_such_a_brittle_life,
    R.raw.dialogue_clinkz_the_bone_fletcher_burns_again,
    R.raw.dialogue_clinkz_time_for_your_cremation,
    R.raw.dialogue_clinkz_what_a_shot,
    R.raw.dialogue_clinkz_your_flesh_fails_you
    )

    val clinkz_sound_titles_Hero_Related = arrayListOf<String>(
    context.getString(R.string.dialogue_clinkz_ashes_to_ashes),
    context.getString(R.string.dialogue_clinkz_burned_you_down),
    context.getString(R.string.dialogue_clinkz_burn_them_down_together),
    context.getString(R.string.dialogue_clinkz_burn_your_body),
    context.getString(R.string.dialogue_clinkz_cremation_is_in_your_future),
    context.getString(R.string.dialogue_clinkz_even_the_dead_can_be_reborn),
    context.getString(R.string.dialogue_clinkz_fire_grows_hungrier),
    context.getString(R.string.dialogue_clinkz_first_blood),
    context.getString(R.string.dialogue_clinkz_for_the_king_mage),
    context.getString(R.string.dialogue_clinkz_gift_of_death),
    context.getString(R.string.dialogue_clinkz_i_plucked_your_life),
    context.getString(R.string.dialogue_clinkz_i_rise_from_the_cinders),
    context.getString(R.string.dialogue_clinkz_killing_ancient_apparition),
    context.getString(R.string.dialogue_clinkz_killing_batrider),
    context.getString(R.string.dialogue_clinkz_killing_crystal_maiden),
    context.getString(R.string.dialogue_clinkz_killing_doom),
    context.getString(R.string.dialogue_clinkz_killing_lich),
    context.getString(R.string.dialogue_clinkz_killing_lina),
    context.getString(R.string.dialogue_clinkz_killing_pudge),
    context.getString(R.string.dialogue_clinkz_killing_windranger),
    context.getString(R.string.dialogue_clinkz_meeting_drow_ranger),
    context.getString(R.string.dialogue_clinkz_meeting_jakiro),
    context.getString(R.string.dialogue_clinkz_meeting_lich),
    context.getString(R.string.dialogue_clinkz_meeting_lina),
    context.getString(R.string.dialogue_clinkz_meeting_pugna),
    context.getString(R.string.dialogue_clinkz_quench_my_arrows),
    context.getString(R.string.dialogue_clinkz_such_a_brittle_life),
    context.getString(R.string.dialogue_clinkz_the_bone_fletcher_burns_again),
    context.getString(R.string.dialogue_clinkz_time_for_your_cremation),
    context.getString(R.string.dialogue_clinkz_what_a_shot),
    context.getString(R.string.dialogue_clinkz_your_flesh_fails_you)
    )
    val clinkz_sound_res_Items = arrayListOf(
            R.raw.dialogue_clinkz_at_last,
            R.raw.dialogue_clinkz_a_fair_exchange,
            R.raw.dialogue_clinkz_bone_dagger,
            R.raw.dialogue_clinkz_bone_march,
            R.raw.dialogue_clinkz_butterfly,
            R.raw.dialogue_clinkz_daedalus,
            R.raw.dialogue_clinkz_divine_rapier_ha_ha_ha,
            R.raw.dialogue_clinkz_exceptional,
            R.raw.dialogue_clinkz_eye_of_skadi,
            R.raw.dialogue_clinkz_guide_my_arrows,
            R.raw.dialogue_clinkz_hang_onto_my_hat,
            R.raw.dialogue_clinkz_if_this_is_fireproof,
            R.raw.dialogue_clinkz_immortality,
            R.raw.dialogue_clinkz_monkey_king_bar,
            R.raw.dialogue_clinkz_my_just_reward,
            R.raw.dialogue_clinkz_orchid_malevolence,
            R.raw.dialogue_clinkz_preserve_these_bones,
            R.raw.dialogue_clinkz_scythe_of_vyse,
            R.raw.dialogue_clinkz_well_bought
    )

    val clinkz_sound_titles_Items = arrayListOf<String>(
            context.getString(R.string.dialogue_clinkz_at_last),
            context.getString(R.string.dialogue_clinkz_a_fair_exchange),
            context.getString(R.string.dialogue_clinkz_bone_dagger),
            context.getString(R.string.dialogue_clinkz_bone_march),
            context.getString(R.string.dialogue_clinkz_butterfly),
            context.getString(R.string.dialogue_clinkz_daedalus),
            context.getString(R.string.dialogue_clinkz_divine_rapier_ha_ha_ha),
            context.getString(R.string.dialogue_clinkz_exceptional),
            context.getString(R.string.dialogue_clinkz_eye_of_skadi),
            context.getString(R.string.dialogue_clinkz_guide_my_arrows),
            context.getString(R.string.dialogue_clinkz_hang_onto_my_hat),
            context.getString(R.string.dialogue_clinkz_if_this_is_fireproof),
            context.getString(R.string.dialogue_clinkz_immortality),
            context.getString(R.string.dialogue_clinkz_monkey_king_bar),
            context.getString(R.string.dialogue_clinkz_my_just_reward),
            context.getString(R.string.dialogue_clinkz_orchid_malevolence),
            context.getString(R.string.dialogue_clinkz_preserve_these_bones),
            context.getString(R.string.dialogue_clinkz_scythe_of_vyse),
            context.getString(R.string.dialogue_clinkz_well_bought)
    )
    val clinkz_sound_res_Misc = arrayListOf(
            R.raw.dialogue_clinkz_aah_ha_ha_ha,
            R.raw.dialogue_clinkz_ah_ha_ha_ha,
            R.raw.dialogue_clinkz_a_light_to_guide_my_way,
            R.raw.dialogue_clinkz_curses,
            R.raw.dialogue_clinkz_guide_my_way,
            R.raw.dialogue_clinkz_heat_rises,
            R.raw.dialogue_clinkz_hell_fire,
            R.raw.dialogue_clinkz_hot_damn,
            R.raw.dialogue_clinkz_immolation,
            R.raw.dialogue_clinkz_im_all_aquiver,
            R.raw.dialogue_clinkz_i_roar_hotter,
            R.raw.dialogue_clinkz_i_thank_you,
            R.raw.dialogue_clinkz_shizzy_wizard,
            R.raw.dialogue_clinkz_well_done,
            R.raw.dialogue_clinkz_where_goes_my_eye,
            R.raw.dialogue_clinkz_woo
    )

    val clinkz_sound_titles_Misc = arrayListOf<String>(
            context.getString(R.string.dialogue_clinkz_aah_ha_ha_ha),
            context.getString(R.string.dialogue_clinkz_ah_ha_ha_ha),
            context.getString(R.string.dialogue_clinkz_a_light_to_guide_my_way),
            context.getString(R.string.dialogue_clinkz_curses),
            context.getString(R.string.dialogue_clinkz_guide_my_way),
            context.getString(R.string.dialogue_clinkz_heat_rises),
            context.getString(R.string.dialogue_clinkz_hell_fire),
            context.getString(R.string.dialogue_clinkz_hot_damn),
            context.getString(R.string.dialogue_clinkz_immolation),
            context.getString(R.string.dialogue_clinkz_im_all_aquiver),
            context.getString(R.string.dialogue_clinkz_i_roar_hotter),
            context.getString(R.string.dialogue_clinkz_i_thank_you),
            context.getString(R.string.dialogue_clinkz_shizzy_wizard),
            context.getString(R.string.dialogue_clinkz_well_done),
            context.getString(R.string.dialogue_clinkz_where_goes_my_eye),
            context.getString(R.string.dialogue_clinkz_woo)
    )

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

    // Ancient Apparition
    val board_header_ancient = R.drawable.header_ancient_apparition
    val ancientapparition_sound_res_Abilities = arrayListOf(
            R.raw.dialogue_ancient_apparition_ahhh_ice_vortex,
            R.raw.dialogue_ancient_apparition_a_preserving_cold,
            R.raw.dialogue_ancient_apparition_blast_ice,
            R.raw.dialogue_ancient_apparition_cold_save_us,
            R.raw.dialogue_ancient_apparition_cold_swirl,
            R.raw.dialogue_ancient_apparition_feel_the_chill,
            R.raw.dialogue_ancient_apparition_freeze,
            R.raw.dialogue_ancient_apparition_got_cold_feet,
            R.raw.dialogue_ancient_apparition_hail_of_death,
            R.raw.dialogue_ancient_apparition_ice_blast,
            R.raw.dialogue_ancient_apparition_ice_preserves_you,
            R.raw.dialogue_ancient_apparition_ice_vortex,
            R.raw.dialogue_ancient_apparition_i_come_for_you,
            R.raw.dialogue_ancient_apparition_sharded_shrapnel,
            R.raw.dialogue_ancient_apparition_shattered,
            R.raw.dialogue_ancient_apparition_spell_of_ages,
            R.raw.dialogue_ancient_apparition_stay_where_you_are
    )

    val ancientapparition_sound_titles_Abilities = arrayListOf<String>(
            context.getString(R.string.dialogue_ancient_apparition_ahhh_ice_vortex),
            context.getString(R.string.dialogue_ancient_apparition_a_preserving_cold),
            context.getString(R.string.dialogue_ancient_apparition_blast_ice),
            context.getString(R.string.dialogue_ancient_apparition_cold_save_us),
            context.getString(R.string.dialogue_ancient_apparition_cold_swirl),
            context.getString(R.string.dialogue_ancient_apparition_feel_the_chill),
            context.getString(R.string.dialogue_ancient_apparition_freeze),
            context.getString(R.string.dialogue_ancient_apparition_got_cold_feet),
            context.getString(R.string.dialogue_ancient_apparition_hail_of_death),
            context.getString(R.string.dialogue_ancient_apparition_ice_blast),
            context.getString(R.string.dialogue_ancient_apparition_ice_preserves_you),
            context.getString(R.string.dialogue_ancient_apparition_ice_vortex),
            context.getString(R.string.dialogue_ancient_apparition_i_come_for_you),
            context.getString(R.string.dialogue_ancient_apparition_sharded_shrapnel),
            context.getString(R.string.dialogue_ancient_apparition_shattered),
            context.getString(R.string.dialogue_ancient_apparition_spell_of_ages),
            context.getString(R.string.dialogue_ancient_apparition_stay_where_you_are)
    )
    val ancientapparition_sound_res_Attacks = arrayListOf(
            R.raw.dialogue_ancient_apparition_age_before_beauty,
            R.raw.dialogue_ancient_apparition_ah_denied,
            R.raw.dialogue_ancient_apparition_ancient_apparition,
            R.raw.dialogue_ancient_apparition_ancient_chill,
            R.raw.dialogue_ancient_apparition_ancient_onslaught,
            R.raw.dialogue_ancient_apparition_attack,
            R.raw.dialogue_ancient_apparition_a_cold_wind_blows,
            R.raw.dialogue_ancient_apparition_a_dark_summons,
            R.raw.dialogue_ancient_apparition_a_new_ice_age_begins,
            R.raw.dialogue_ancient_apparition_a_tidy_sum,
            R.raw.dialogue_ancient_apparition_behold_the_apparition,
            R.raw.dialogue_ancient_apparition_blast_you,
            R.raw.dialogue_ancient_apparition_break_you_down,
            R.raw.dialogue_ancient_apparition_colder_than_gold,
            R.raw.dialogue_ancient_apparition_cold_blooded,
            R.raw.dialogue_ancient_apparition_cold_shard_cash,
            R.raw.dialogue_ancient_apparition_cold_terror,
            R.raw.dialogue_ancient_apparition_defeated,
            R.raw.dialogue_ancient_apparition_denied,
            R.raw.dialogue_ancient_apparition_feh_youth_today,
            R.raw.dialogue_ancient_apparition_froze_you_out,
            R.raw.dialogue_ancient_apparition_hoary_frost_upon_ypu,
            R.raw.dialogue_ancient_apparition_huh_uh,
            R.raw.dialogue_ancient_apparition_icefog,
            R.raw.dialogue_ancient_apparition_ice_elemental,
            R.raw.dialogue_ancient_apparition_in_cold_blood,
            R.raw.dialogue_ancient_apparition_i_run_cold,
            R.raw.dialogue_ancient_apparition_i_think_not,
            R.raw.dialogue_ancient_apparition_noooooo,
            R.raw.dialogue_ancient_apparition_not_til_youre_older,
            R.raw.dialogue_ancient_apparition_no_defeat,
            R.raw.dialogue_ancient_apparition_permafrost,
            R.raw.dialogue_ancient_apparition_sap_your_heart,
            R.raw.dialogue_ancient_apparition_senior_discount,
            R.raw.dialogue_ancient_apparition_the_age_of_ice_begins,
            R.raw.dialogue_ancient_apparition_the_cost_of_frost,
            R.raw.dialogue_ancient_apparition_the_ice_age_ends,
            R.raw.dialogue_ancient_apparition_victory,
            R.raw.dialogue_ancient_apparition_wages_of_war,
            R.raw.dialogue_ancient_apparition_yes_victory
    )

    val ancientapparition_sound_titles_Attacks = arrayListOf<String>(
            context.getString(R.string.dialogue_ancient_apparition_age_before_beauty),
            context.getString(R.string.dialogue_ancient_apparition_ah_denied),
            context.getString(R.string.dialogue_ancient_apparition_ancient_apparition),
            context.getString(R.string.dialogue_ancient_apparition_ancient_chill),
            context.getString(R.string.dialogue_ancient_apparition_ancient_onslaught),
            context.getString(R.string.dialogue_ancient_apparition_attack),
            context.getString(R.string.dialogue_ancient_apparition_a_cold_wind_blows),
            context.getString(R.string.dialogue_ancient_apparition_a_dark_summons),
            context.getString(R.string.dialogue_ancient_apparition_a_new_ice_age_begins),
            context.getString(R.string.dialogue_ancient_apparition_a_tidy_sum),
            context.getString(R.string.dialogue_ancient_apparition_behold_the_apparition),
            context.getString(R.string.dialogue_ancient_apparition_blast_you),
            context.getString(R.string.dialogue_ancient_apparition_break_you_down),
            context.getString(R.string.dialogue_ancient_apparition_colder_than_gold),
            context.getString(R.string.dialogue_ancient_apparition_cold_blooded),
            context.getString(R.string.dialogue_ancient_apparition_cold_shard_cash),
            context.getString(R.string.dialogue_ancient_apparition_cold_terror),
            context.getString(R.string.dialogue_ancient_apparition_defeated),
            context.getString(R.string.dialogue_ancient_apparition_denied),
            context.getString(R.string.dialogue_ancient_apparition_feh_youth_today),
            context.getString(R.string.dialogue_ancient_apparition_froze_you_out),
            context.getString(R.string.dialogue_ancient_apparition_hoary_frost_upon_ypu),
            context.getString(R.string.dialogue_ancient_apparition_huh_uh),
            context.getString(R.string.dialogue_ancient_apparition_icefog),
            context.getString(R.string.dialogue_ancient_apparition_ice_elemental),
            context.getString(R.string.dialogue_ancient_apparition_in_cold_blood),
            context.getString(R.string.dialogue_ancient_apparition_i_run_cold),
            context.getString(R.string.dialogue_ancient_apparition_i_think_not),
            context.getString(R.string.dialogue_ancient_apparition_noooooo),
            context.getString(R.string.dialogue_ancient_apparition_not_til_youre_older),
            context.getString(R.string.dialogue_ancient_apparition_no_defeat),
            context.getString(R.string.dialogue_ancient_apparition_permafrost),
            context.getString(R.string.dialogue_ancient_apparition_sap_your_heart),
            context.getString(R.string.dialogue_ancient_apparition_senior_discount),
            context.getString(R.string.dialogue_ancient_apparition_the_age_of_ice_begins),
            context.getString(R.string.dialogue_ancient_apparition_the_cost_of_frost),
            context.getString(R.string.dialogue_ancient_apparition_the_ice_age_ends),
            context.getString(R.string.dialogue_ancient_apparition_victory),
            context.getString(R.string.dialogue_ancient_apparition_wages_of_war),
            context.getString(R.string.dialogue_ancient_apparition_yes_victory)
    )
    val ancientapparition_sound_res_Hero_Related = arrayListOf(
            R.raw.dialogue_ancient_apparition_and_so_i_gather,
            R.raw.dialogue_ancient_apparition_another_ice_age_is_coming,
            R.raw.dialogue_ancient_apparition_a_free_spirit,
            R.raw.dialogue_ancient_apparition_a_new_ice_age_dawns,
            R.raw.dialogue_ancient_apparition_colder_than_hells_heart_i_return,
            R.raw.dialogue_ancient_apparition_cold_fusion,
            R.raw.dialogue_ancient_apparition_cold_hand_cold_heart,
            R.raw.dialogue_ancient_apparition_dispersed_to_the_winds,
            R.raw.dialogue_ancient_apparition_exempt_from_times_ablations,
            R.raw.dialogue_ancient_apparition_first_blood,
            R.raw.dialogue_ancient_apparition_ill_be_freezing_again_soon,
            R.raw.dialogue_ancient_apparition_im_too_old_for_this,
            R.raw.dialogue_ancient_apparition_ive_been_on_ice,
            R.raw.dialogue_ancient_apparition_i_look_again_upon_the_cold_light_of_day,
            R.raw.dialogue_ancient_apparition_i_return_from_the_cold_and_the_dark,
            R.raw.dialogue_ancient_apparition_i_return_to_times_cradle,
            R.raw.dialogue_ancient_apparition_my_vapors_coalesce,
            R.raw.dialogue_ancient_apparition_out_cold,
            R.raw.dialogue_ancient_apparition_spirited_away,
            R.raw.dialogue_ancient_apparition_the_heat_is_on,
            R.raw.dialogue_ancient_apparition_the_spirit_is_willing_but_the_ice_is_weak,
            R.raw.dialogue_ancient_apparition_warmer_climates_await,
            R.raw.dialogue_ancient_apparition_winter_always_returns
    )

    val ancientapparition_sound_titles_Hero_Related = arrayListOf<String>(
            context.getString(R.string.dialogue_ancient_apparition_and_so_i_gather),
            context.getString(R.string.dialogue_ancient_apparition_another_ice_age_is_coming),
            context.getString(R.string.dialogue_ancient_apparition_a_free_spirit),
            context.getString(R.string.dialogue_ancient_apparition_a_new_ice_age_dawns),
            context.getString(R.string.dialogue_ancient_apparition_colder_than_hells_heart_i_return),
            context.getString(R.string.dialogue_ancient_apparition_cold_fusion),
            context.getString(R.string.dialogue_ancient_apparition_cold_hand_cold_heart),
            context.getString(R.string.dialogue_ancient_apparition_dispersed_to_the_winds),
            context.getString(R.string.dialogue_ancient_apparition_exempt_from_times_ablations),
            context.getString(R.string.dialogue_ancient_apparition_first_blood),
            context.getString(R.string.dialogue_ancient_apparition_ill_be_freezing_again_soon),
            context.getString(R.string.dialogue_ancient_apparition_im_too_old_for_this),
            context.getString(R.string.dialogue_ancient_apparition_ive_been_on_ice),
            context.getString(R.string.dialogue_ancient_apparition_i_look_again_upon_the_cold_light_of_day),
            context.getString(R.string.dialogue_ancient_apparition_i_return_from_the_cold_and_the_dark),
            context.getString(R.string.dialogue_ancient_apparition_i_return_to_times_cradle),
            context.getString(R.string.dialogue_ancient_apparition_my_vapors_coalesce),
            context.getString(R.string.dialogue_ancient_apparition_out_cold),
            context.getString(R.string.dialogue_ancient_apparition_spirited_away),
            context.getString(R.string.dialogue_ancient_apparition_the_heat_is_on),
            context.getString(R.string.dialogue_ancient_apparition_the_spirit_is_willing_but_the_ice_is_weak),
            context.getString(R.string.dialogue_ancient_apparition_warmer_climates_await),
            context.getString(R.string.dialogue_ancient_apparition_winter_always_returns)
    )
    val ancientapparition_sound_res_Items = arrayListOf(
            R.raw.dialogue_ancient_apparition_ah_mekansm,
            R.raw.dialogue_ancient_apparition_ah_scepter,
            R.raw.dialogue_ancient_apparition_ah_sheepstick,
            R.raw.dialogue_ancient_apparition_at_last_i_have_you,
            R.raw.dialogue_ancient_apparition_blink_dagger,
            R.raw.dialogue_ancient_apparition_clear_as_ice,
            R.raw.dialogue_ancient_apparition_cold_comfort,
            R.raw.dialogue_ancient_apparition_couldnt_catch_a_cold,
            R.raw.dialogue_ancient_apparition_double_damage,
            R.raw.dialogue_ancient_apparition_double_digit_wind_chill,
            R.raw.dialogue_ancient_apparition_endless_winter,
            R.raw.dialogue_ancient_apparition_eye_of_skadi,
            R.raw.dialogue_ancient_apparition_flash_freeze,
            R.raw.dialogue_ancient_apparition_for_a_time_of_need,
            R.raw.dialogue_ancient_apparition_haste,
            R.raw.dialogue_ancient_apparition_illusion,
            R.raw.dialogue_ancient_apparition_ill_move_in_a_fog_of_war,
            R.raw.dialogue_ancient_apparition_ill_put_this_on_ice,
            R.raw.dialogue_ancient_apparition_immortality,
            R.raw.dialogue_ancient_apparition_interesting,
            R.raw.dialogue_ancient_apparition_invisibility,
            R.raw.dialogue_ancient_apparition_i_waited_ages_but_this_was_worth_it,
            R.raw.dialogue_ancient_apparition_later,
            R.raw.dialogue_ancient_apparition_regeneration,
            R.raw.dialogue_ancient_apparition_scepter_a_shard_of_ice,
            R.raw.dialogue_ancient_apparition_sharp_as_winters_teeth,
            R.raw.dialogue_ancient_apparition_three_the_shard_way,
            R.raw.dialogue_ancient_apparition_thrice_the_ice,
            R.raw.dialogue_ancient_apparition_two_cold,
            R.raw.dialogue_ancient_apparition_unfroze_my_assets_just_for_this
    )

    val ancientapparition_sound_titles_Items = arrayListOf<String>(
            context.getString(R.string.dialogue_ancient_apparition_ah_mekansm),
            context.getString(R.string.dialogue_ancient_apparition_ah_scepter),
            context.getString(R.string.dialogue_ancient_apparition_ah_sheepstick),
            context.getString(R.string.dialogue_ancient_apparition_at_last_i_have_you),
            context.getString(R.string.dialogue_ancient_apparition_blink_dagger),
            context.getString(R.string.dialogue_ancient_apparition_clear_as_ice),
            context.getString(R.string.dialogue_ancient_apparition_cold_comfort),
            context.getString(R.string.dialogue_ancient_apparition_couldnt_catch_a_cold),
            context.getString(R.string.dialogue_ancient_apparition_double_damage),
            context.getString(R.string.dialogue_ancient_apparition_double_digit_wind_chill),
            context.getString(R.string.dialogue_ancient_apparition_endless_winter),
            context.getString(R.string.dialogue_ancient_apparition_eye_of_skadi),
            context.getString(R.string.dialogue_ancient_apparition_flash_freeze),
            context.getString(R.string.dialogue_ancient_apparition_for_a_time_of_need),
            context.getString(R.string.dialogue_ancient_apparition_haste),
            context.getString(R.string.dialogue_ancient_apparition_illusion),
            context.getString(R.string.dialogue_ancient_apparition_ill_move_in_a_fog_of_war),
            context.getString(R.string.dialogue_ancient_apparition_ill_put_this_on_ice),
            context.getString(R.string.dialogue_ancient_apparition_immortality),
            context.getString(R.string.dialogue_ancient_apparition_interesting),
            context.getString(R.string.dialogue_ancient_apparition_invisibility),
            context.getString(R.string.dialogue_ancient_apparition_i_waited_ages_but_this_was_worth_it),
            context.getString(R.string.dialogue_ancient_apparition_later),
            context.getString(R.string.dialogue_ancient_apparition_regeneration),
            context.getString(R.string.dialogue_ancient_apparition_scepter_a_shard_of_ice),
            context.getString(R.string.dialogue_ancient_apparition_sharp_as_winters_teeth),
            context.getString(R.string.dialogue_ancient_apparition_three_the_shard_way),
            context.getString(R.string.dialogue_ancient_apparition_thrice_the_ice),
            context.getString(R.string.dialogue_ancient_apparition_two_cold),
            context.getString(R.string.dialogue_ancient_apparition_unfroze_my_assets_just_for_this)
    )
    val ancientapparition_sound_res_Misc = arrayListOf(
            R.raw.dialogue_ancient_apparition_absolute_zero,
            R.raw.dialogue_ancient_apparition_ancient_but_hardly_frail,
            R.raw.dialogue_ancient_apparition_crummy_wizard,
            R.raw.dialogue_ancient_apparition_ha_ha,
            R.raw.dialogue_ancient_apparition_ice_takes_all,
            R.raw.dialogue_ancient_apparition_older_and_wiser
    )

    val ancientapparition_sound_titles_Misc = arrayListOf<String>(
            context.getString(R.string.dialogue_ancient_apparition_absolute_zero),
            context.getString(R.string.dialogue_ancient_apparition_ancient_but_hardly_frail),
            context.getString(R.string.dialogue_ancient_apparition_crummy_wizard),
            context.getString(R.string.dialogue_ancient_apparition_ha_ha),
            context.getString(R.string.dialogue_ancient_apparition_ice_takes_all),
            context.getString(R.string.dialogue_ancient_apparition_older_and_wiser)
    )


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