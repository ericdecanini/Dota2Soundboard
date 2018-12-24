package pandastudios.dotasound

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdRequest
import pandastudios.dotasound.arrays.*

class AssignHeroesTask(var listener: OnAssignHeroesCompleted, var context: Context) : AsyncTask<String, Void, Bundle>() {

    val LOG_TAG = AssignHeroesTask::class.java.simpleName

    override fun doInBackground(vararg heroKey: String): Bundle {
        val soundsListAttack = ArrayList<Sound>()
        val soundsListAttackMorphed = ArrayList<Sound>()
        val soundsListAbilities = ArrayList<Sound>()
        val soundsListAbilitiesMorphed = ArrayList<Sound>()
        val soundsListItems = ArrayList<Sound>()
        val soundsListItemsMorphed = ArrayList<Sound>()
        val soundsListGame = ArrayList<Sound>()
        val soundsListGameMorphed = ArrayList<Sound>()
        val soundsListHeroRelated = ArrayList<Sound>()
        val soundsListHeroRelatedMorphed = ArrayList<Sound>()
        val soundsListMisc = ArrayList<Sound>()
        val soundsListMiscMorphed = ArrayList<Sound>()

        val soundUriListAttack = ArrayList<String>()
        val soundUriListAttackMorphed = ArrayList<String>()
        val soundTitlesListAttack = ArrayList<String>()

        val soundUriListAbilities = ArrayList<String>()
        val soundUriListAbilitiesMorphed = ArrayList<String>()
        val soundTitlesListAbilities = ArrayList<String>()

        val soundUriListItems = ArrayList<String>()
        val soundUriListItemsMorphed = ArrayList<String>()
        val soundTitlesListItems = ArrayList<String>()

        val soundUriListGame = ArrayList<String>()
        val soundUriListGameMorphed = ArrayList<String>()
        val soundTitlesListGame = ArrayList<String>()

        val soundUriListHeroRelated = ArrayList<String>()
        val soundUriListHeroRelatedMorphed = ArrayList<String>()
        val soundTitlesListHeroRelated = ArrayList<String>()

        val soundUriListMisc = ArrayList<String>()
        val soundUriListMiscMorphed = ArrayList<String>()
        val soundTitlesListMisc = ArrayList<String>()

        val miscArrays = MiscArrays(context)

        var imageRes: Int

        // Safety Check
        if (heroKey.size != 1)
            return Bundle()

        when (heroKey[0]) {
            context.getString(R.string.ti7) -> {
                imageRes = miscArrays.ti7_board_header
                val soundArraysMisc = SoundArraysMisc(context)
                soundUriListAttack.addAll(soundArraysMisc.ti7_sound_res)
                soundTitlesListAttack.addAll(soundArraysMisc.ti7_sound_titles)
            }

            context.getString(R.string.music) -> {
                imageRes = miscArrays.board_header_music
                val soundArraysMisc = SoundArraysMisc(context)
                soundUriListAttack.addAll(soundArraysMisc.music_sound_res_misc)
                soundTitlesListAttack.addAll(soundArraysMisc.music_sound_titles_misc)
            }

            context.getString(R.string.ti8) -> {
                imageRes = miscArrays.ti8_board_header
                val soundArraysMisc = SoundArraysMisc(context)
                soundUriListAttack.addAll(soundArraysMisc.ti8_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysMisc.ti8_sound_titles_Attacks)
            }

            context.getString(R.string.gabenewell) -> {
                imageRes = miscArrays.gabenewell_board_header
                val soundArraysMisc = SoundArraysMisc(context)
                soundUriListAttack.addAll(soundArraysMisc.gabenewell_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysMisc.gabenewell_sound_titles_Attacks)
            }

            context.getString(R.string.rickandmorty) -> {
                val soundArraysMisc = SoundArraysMisc(context)
                imageRes = miscArrays.rickandmorty_board_header
                soundUriListGame.addAll(soundArraysMisc.rickandmorty_sound_res_Game)
                soundTitlesListGame.addAll(soundArraysMisc.rickandmorty_sound_titles_Game)
                soundUriListHeroRelated.addAll(soundArraysMisc.rickandmorty_sound_res_Encounters)
                soundTitlesListHeroRelated.addAll(soundArraysMisc.rickandmorty_sound_titles_Encounters)
                soundUriListMisc.addAll(soundArraysMisc.rickandmorty_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysMisc.rickandmorty_sound_titles_Misc)
            }

            context.getString(R.string.Abaddon) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_abaddon
                soundUriListAttack.addAll(soundArraysS1.abaddon_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.abaddon_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.abaddon_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.abaddon_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.abaddon_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.abaddon_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.abaddon_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.abaddon_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.abaddon_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.abaddon_sound_titles_Misc)
            }

            context.getString(R.string.Alchemist) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_alchemist
                soundUriListAttack.addAll(soundArraysS1.alchemist_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.alchemist_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.alchemist_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.alchemist_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.alchemist_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.alchemist_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.alchemist_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.alchemist_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.alchemist_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.alchemist_sound_titles_Misc)
            }

            context.getString(R.string.Axe) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_axe
                soundUriListAttack.addAll(soundArraysS1.axe_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.axe_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.axe_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.axe_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.axe_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.axe_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.axe_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.axe_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.axe_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.axe_sound_titles_Misc)
            }

            context.getString(R.string.Beastmaster) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_beastmaster
                soundUriListAttack.addAll(soundArraysS1.beastmaster_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.beastmaster_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.beastmaster_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.beastmaster_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.beastmaster_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.beastmaster_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.beastmaster_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.beastmaster_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.beastmaster_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.beastmaster_sound_titles_Misc)
            }

            context.getString(R.string.Brewmaster) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_brewmaster
                soundUriListAttack.addAll(soundArraysS1.brewmaster_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.brewmaster_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.brewmaster_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.brewmaster_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.brewmaster_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.brewmaster_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.brewmaster_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.brewmaster_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.brewmaster_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.brewmaster_sound_titles_Misc)
            }

            context.getString(R.string.Bristleback) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_bristleback
                soundUriListAttack.addAll(soundArraysS1.bristleback_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.bristleback_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.bristleback_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.bristleback_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.bristleback_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.bristleback_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.bristleback_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.bristleback_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.bristleback_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.bristleback_sound_titles_Misc)
            }

            context.getString(R.string.Centaur) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_centaur
                soundUriListAttack.addAll(soundArraysS1.centaurwarrunner_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.centaurwarrunner_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.centaurwarrunner_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.centaurwarrunner_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.centaurwarrunner_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.centaurwarrunner_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.centaurwarrunner_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.centaurwarrunner_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.centaurwarrunner_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.centaurwarrunner_sound_titles_Misc)
            }

            context.getString(R.string.Chaosknight) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_ck
                soundUriListAttack.addAll(soundArraysS1.chaosknight_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.chaosknight_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.chaosknight_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.chaosknight_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.chaosknight_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.chaosknight_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.chaosknight_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.chaosknight_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.chaosknight_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.chaosknight_sound_titles_Misc)
            }

            context.getString(R.string.Clockwerk) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_clock
                soundUriListAttack.addAll(soundArraysS1.clockwerk_sound_res_attacking)
                soundTitlesListAttack.addAll(soundArraysS1.clockwerk_sound_titles_attacking)
                soundUriListAbilities.addAll(soundArraysS1.clockwerk_sound_res_abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.clockwerk_sound_titles_abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.clockwerk_sound_res_hero_related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.clockwerk_sound_titles_hero_related)
                soundUriListItems.addAll(soundArraysS1.clockwerk_sound_res_items)
                soundTitlesListItems.addAll(soundArraysS1.clockwerk_sound_titles_items)
                soundUriListMisc.addAll(soundArraysS1.clockwerk_sound_res_misc)
                soundTitlesListMisc.addAll(soundArraysS1.clockwerk_sound_titles_misc)
            }

            context.getString(R.string.Doom) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_doom
                soundUriListAttack.addAll(soundArraysS1.doom_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.doom_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.doom_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.doom_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.doom_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.doom_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.doom_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.doom_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.doom_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.doom_sound_titles_Misc)
            }

            context.getString(R.string.Dragonknight) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_dk
                soundUriListAttack.addAll(soundArraysS1.dragonknight_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.dragonknight_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.dragonknight_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.dragonknight_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.dragonknight_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.dragonknight_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.dragonknight_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.dragonknight_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.dragonknight_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.dragonknight_sound_titles_Misc)
            }

            context.getString(R.string.Earthspirit) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_earth
                soundUriListAttack.addAll(soundArraysS2.earthspirit_sound_res_attacks)
                soundTitlesListAttack.addAll(soundArraysS2.earthspirit_sound_titles_attacks)
                soundUriListAbilities.addAll(soundArraysS2.earthspirit_sound_res_abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.earthspirit_sound_titles_abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.earthspirit_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.earthspirit_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.earthspirit_sound_res_items)
                soundTitlesListItems.addAll(soundArraysS2.earthspirit_sound_titles_items)
                soundUriListMisc.addAll(soundArraysS2.earthspirit_sound_res_misc)
                soundTitlesListMisc.addAll(soundArraysS2.earthspirit_sound_titles_misc)
            }

            context.getString(R.string.Earthshaker) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_es
                soundUriListAttack.addAll(soundArraysS1.earthshaker_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.earthshaker_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.earthshaker_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.earthshaker_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.earthshaker_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.earthshaker_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.earthshaker_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.earthshaker_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.earthshaker_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.earthshaker_sound_titles_Misc)
            }

            context.getString(R.string.Eldertitan) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_elder
                soundUriListAttack.addAll(soundArraysS2.eldertitan_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.eldertitan_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.eldertitan_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.eldertitan_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.eldertitan_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.eldertitan_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.eldertitan_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.eldertitan_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.eldertitan_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.eldertitan_sound_titles_Misc)
            }

            context.getString(R.string.Huskar) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_huskar
                soundUriListAttack.addAll(soundArraysS2.huskar_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.huskar_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.huskar_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.huskar_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.huskar_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.huskar_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.huskar_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.huskar_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.huskar_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.huskar_sound_titles_Misc)
            }

            context.getString(R.string.Io) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_io
                soundUriListAttack.addAll(soundArraysS2.io_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.io_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.io_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.io_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.io_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.io_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.io_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.io_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.io_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.io_sound_titles_Misc)
            }

            context.getString(R.string.Kunkka) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_kunkka
                soundUriListAttack.addAll(soundArraysS2.kunkka_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.kunkka_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.kunkka_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.kunkka_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.kunkka_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.kunkka_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.kunkka_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.kunkka_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.kunkka_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.kunkka_sound_titles_Misc)
            }

            context.getString(R.string.Legioncommander) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_lc
                soundUriListAttack.addAll(soundArraysS2.legioncommander_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.legioncommander_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.legioncommander_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.legioncommander_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.legioncommander_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.legioncommander_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.legioncommander_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.legioncommander_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.legioncommander_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.legioncommander_sound_titles_Misc)
            }

            context.getString(R.string.Lifestealer) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_lifestealer
                soundUriListAttack.addAll(soundArraysS2.lifestealer_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.lifestealer_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.lifestealer_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.lifestealer_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.lifestealer_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.lifestealer_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.lifestealer_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.lifestealer_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.lifestealer_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.lifestealer_sound_titles_Misc)
            }

            context.getString(R.string.Lycan) -> {
                val soundArraysS2 = SoundArraysS2(context)
                imageRes = miscArrays.board_header_lycan
                soundUriListAttack.addAll(soundArraysS2.lycan_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS2.lycan_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS2.lycan_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS2.lycan_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS2.lycan_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS2.lycan_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS2.lycan_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS2.lycan_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS2.lycan_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS2.lycan_sound_titles_Misc)
            }

            context.getString(R.string.Magnus) -> {
                val soundArraysS4 = SoundArraysS4(context)
                imageRes = miscArrays.board_header_magnus
                soundUriListAttack.addAll(soundArraysS4.magnus_sound_res_attacking)
                soundTitlesListAttack.addAll(soundArraysS4.magnus_sound_titles_attacking)
                soundUriListAbilities.addAll(soundArraysS4.magnus_sound_res_abilities)
                soundTitlesListAbilities.addAll(soundArraysS4.magnus_sound_titles_abilities)
                soundUriListHeroRelated.addAll(soundArraysS4.magnus_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS4.magnus_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS4.magnus_sound_res_items)
                soundTitlesListItems.addAll(soundArraysS4.magnus_sound_titles_items)
                soundUriListMisc.addAll(soundArraysS4.magnus_sound_res_misc)
                soundTitlesListMisc.addAll(soundArraysS4.magnus_sound_titles_misc)
            }

            context.getString(R.string.Nightstalker) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_ns
                soundUriListAttack.addAll(soundArraysS3.nightstalker_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.nightstalker_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.nightstalker_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.nightstalker_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.nightstalker_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.nightstalker_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.nightstalker_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.nightstalker_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.nightstalker_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.nightstalker_sound_titles_Misc)
            }

            context.getString(R.string.Omniknight) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_omniknight
                soundUriListAttack.addAll(soundArraysS3.omniknight_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.omniknight_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.omniknight_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.omniknight_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.omniknight_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.omniknight_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.omniknight_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.omniknight_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.omniknight_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.omniknight_sound_titles_Misc)
            }

            context.getString(R.string.Phoenix) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_phoenix
                soundUriListAttack.addAll(soundArraysS3.phoenix_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.phoenix_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.phoenix_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.phoenix_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.phoenix_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.phoenix_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.phoenix_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.phoenix_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.phoenix_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.phoenix_sound_titles_Misc)
            }

            context.getString(R.string.Pudge) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_pudge
                soundUriListAttack.addAll(soundArraysS3.pudge_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.pudge_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.pudge_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.pudge_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.pudge_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.pudge_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.pudge_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.pudge_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.pudge_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.pudge_sound_titles_Misc)
            }

            context.getString(R.string.Sandking) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_sk
                soundUriListAttack.addAll(soundArraysS3.sandking_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.sandking_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.sandking_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.sandking_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.sandking_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.sandking_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.sandking_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.sandking_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.sandking_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.sandking_sound_titles_Misc)
            }

            context.getString(R.string.Slardar) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_slardar
                soundUriListAttack.addAll(soundArraysS3.slardar_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.slardar_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.slardar_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.slardar_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.slardar_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.slardar_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.slardar_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.slardar_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.slardar_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.slardar_sound_titles_Misc)
            }

            context.getString(R.string.Spiritbreaker) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_sb
                soundUriListAttack.addAll(soundArraysS3.spiritbreaker_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.spiritbreaker_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.spiritbreaker_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.spiritbreaker_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.spiritbreaker_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.spiritbreaker_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.spiritbreaker_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.spiritbreaker_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.spiritbreaker_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.spiritbreaker_sound_titles_Misc)
            }

            context.getString(R.string.Sven) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_sven
                soundUriListAttack.addAll(soundArraysS3.sven_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.sven_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.sven_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.sven_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.sven_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.sven_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.sven_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.sven_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.sven_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.sven_sound_titles_Misc)
            }

            context.getString(R.string.Tidehunter) -> {
                val soundArraysS3 = SoundArraysS3(context)
                imageRes = miscArrays.board_header_tide
                soundUriListAttack.addAll(soundArraysS3.tidehunter_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS3.tidehunter_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS3.tidehunter_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS3.tidehunter_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS3.tidehunter_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS3.tidehunter_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS3.tidehunter_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS3.tidehunter_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS3.tidehunter_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS3.tidehunter_sound_titles_Misc)
            }

            context.getString(R.string.Timbersaw) -> {
                val soundArraysS4 = SoundArraysS4(context)
                imageRes = miscArrays.board_header_timber
                soundUriListAttack.addAll(soundArraysS4.timbersaw_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS4.timbersaw_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS4.timbersaw_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS4.timbersaw_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS4.timbersaw_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS4.timbersaw_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS4.timbersaw_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS4.timbersaw_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS4.timbersaw_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS4.timbersaw_sound_titles_Misc)
            }

            context.getString(R.string.Tiny) -> {
                val soundArraysS4 = SoundArraysS4(context)
                imageRes = miscArrays.board_header_tiny
                soundUriListAttack.addAll(soundArraysS4.tiny_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS4.tiny_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS4.tiny_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS4.tiny_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS4.tiny_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS4.tiny_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS4.tiny_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS4.tiny_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS4.tiny_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS4.tiny_sound_titles_Misc)
            }

            context.getString(R.string.Treantprotector) -> {
                val soundArraysS4 = SoundArraysS4(context)
                imageRes = miscArrays.board_header_treant
                soundUriListAttack.addAll(soundArraysS4.treantprotector_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS4.treantprotector_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS4.treantprotector_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS4.treantprotector_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS4.treantprotector_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS4.treantprotector_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS4.treantprotector_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS4.treantprotector_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS4.treantprotector_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS4.treantprotector_sound_titles_Misc)
            }

            context.getString(R.string.Tusk) -> {
                val soundArraysS4 = SoundArraysS4(context)
                imageRes = miscArrays.board_header_tusk
                soundUriListAttack.addAll(soundArraysS4.tusk_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS4.tusk_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS4.tusk_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS4.tusk_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS4.tusk_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS4.tusk_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS4.tusk_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS4.tusk_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS4.tusk_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS4.tusk_sound_titles_Misc)
            }

            context.getString(R.string.Underlord) -> {
                val soundArraysS4 = SoundArraysS4(context)
                imageRes = miscArrays.board_header_underlord
                soundUriListAttack.addAll(soundArraysS4.underlord_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS4.underlord_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS4.underlord_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS4.underlord_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS4.underlord_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS4.underlord_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS4.underlord_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS4.underlord_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS4.underlord_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS4.underlord_sound_titles_Misc)
            }

            context.getString(R.string.Undying) -> {
                val soundArraysS5 = SoundArraysS5(context)
                imageRes = miscArrays.board_header_undying
                soundUriListAttack.addAll(soundArraysS5.undying_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS5.undying_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS5.undying_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS5.undying_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS5.undying_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS5.undying_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS5.undying_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS5.undying_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS5.undying_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS5.undying_sound_titles_Misc)
            }

            context.getString(R.string.Wraithking) -> {
                val soundArraysS5 = SoundArraysS5(context)
                imageRes = miscArrays.board_header_wk
                soundUriListAttack.addAll(soundArraysS5.wraithking_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS5.wraithking_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS5.wraithking_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS5.wraithking_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS5.wraithking_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS5.wraithking_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS5.wraithking_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS5.wraithking_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS5.wraithking_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS5.wraithking_sound_titles_Misc)
            }

            context.getString(R.string.Antimage) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_antimage
                soundUriListAttack.addAll(soundArraysA1.antimage_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.antimage_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.antimage_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.antimage_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.antimage_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.antimage_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.antimage_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.antimage_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.antimage_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.antimage_sound_titles_Misc)
            }

            context.getString(R.string.Arcwarden) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_arc
                soundUriListAttack.addAll(soundArraysA1.arcwarden_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.arcwarden_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.arcwarden_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.arcwarden_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.arcwarden_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.arcwarden_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.arcwarden_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.arcwarden_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.arcwarden_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.arcwarden_sound_titles_Misc)
            }

            context.getString(R.string.Bloodseeker) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_bloodseeker
                soundUriListAttack.addAll(soundArraysA1.bloodseeker_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.bloodseeker_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.bloodseeker_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.bloodseeker_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.bloodseeker_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.bloodseeker_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.bloodseeker_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.bloodseeker_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.bloodseeker_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.bloodseeker_sound_titles_Misc)
            }

            context.getString(R.string.Bountyhunter) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_bh
                soundUriListAttack.addAll(soundArraysA1.bountyhunter_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.bountyhunter_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.bountyhunter_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.bountyhunter_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.bountyhunter_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.bountyhunter_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.bountyhunter_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.bountyhunter_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.bountyhunter_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.bountyhunter_sound_titles_Misc)
            }

            context.getString(R.string.Broodmother) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_brood
                soundUriListAttack.addAll(soundArraysA1.broodmother_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.broodmother_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.broodmother_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.broodmother_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.broodmother_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.broodmother_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.broodmother_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.broodmother_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.broodmother_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.broodmother_sound_titles_Misc)
            }

            context.getString(R.string.Clinkz) -> {

                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_clinkz
                soundUriListAttack.addAll(soundArraysS1.clinkz_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.clinkz_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.clinkz_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.clinkz_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.clinkz_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.clinkz_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.clinkz_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.clinkz_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.clinkz_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.clinkz_sound_titles_Misc)
            }

            context.getString(R.string.Drowranger) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_drow
                soundUriListAttack.addAll(soundArraysA1.drowranger_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.drowranger_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.drowranger_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.drowranger_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.drowranger_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.drowranger_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.drowranger_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.drowranger_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.drowranger_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.drowranger_sound_titles_Misc)
            }

            context.getString(R.string.Emberspirit) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_ember
                soundUriListAttack.addAll(soundArraysA1.emberspirit_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.emberspirit_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.emberspirit_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.emberspirit_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.emberspirit_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.emberspirit_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.emberspirit_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.emberspirit_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.emberspirit_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.emberspirit_sound_titles_Misc)
            }

            context.getString(R.string.Facelessvoid) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_faceless
                soundUriListAttack.addAll(soundArraysA1.facelessvoid_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.facelessvoid_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.facelessvoid_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.facelessvoid_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.facelessvoid_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.facelessvoid_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.facelessvoid_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.facelessvoid_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.facelessvoid_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.facelessvoid_sound_titles_Misc)
            }

            context.getString(R.string.Gyrocopter) -> {
                val soundArraysA1 = SoundArraysA1(context)
                imageRes = miscArrays.board_header_gyro
                soundUriListAttack.addAll(soundArraysA1.gyrocopter_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA1.gyrocopter_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA1.gyrocopter_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA1.gyrocopter_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA1.gyrocopter_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA1.gyrocopter_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA1.gyrocopter_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA1.gyrocopter_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA1.gyrocopter_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA1.gyrocopter_sound_titles_Misc)
            }

            context.getString(R.string.Juggernaut) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_juggernaut
                soundUriListAttack.addAll(soundArraysA4.juggernaut_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.juggernaut_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.juggernaut_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.juggernaut_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.juggernaut_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.juggernaut_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.juggernaut_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.juggernaut_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.juggernaut_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.juggernaut_sound_titles_Misc)
            }

            context.getString(R.string.Lonedruid) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_ld
                soundUriListAttack.addAll(soundArraysA2.lonedruid_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.lonedruid_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.lonedruid_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.lonedruid_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.lonedruid_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.lonedruid_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.lonedruid_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.lonedruid_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.lonedruid_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA2.lonedruid_sound_titles_Misc)
            }

            context.getString(R.string.Luna) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_luna
                soundUriListAttack.addAll(soundArraysA2.luna_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.luna_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.luna_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.luna_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.luna_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.luna_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.luna_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.luna_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.luna_sound_res_Miscellaneous)
                soundTitlesListMisc.addAll(soundArraysA2.luna_sound_titles_Miscellaneous)
            }

            context.getString(R.string.Medusa) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_medusa
                soundUriListAttack.addAll(soundArraysA2.medusa_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.medusa_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.medusa_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.medusa_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.medusa_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.medusa_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.medusa_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.medusa_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.medusa_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA2.medusa_sound_titles_Misc)
            }

            context.getString(R.string.Meepo) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_meepo
                soundUriListAttack.addAll(soundArraysA2.meepo_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.meepo_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.meepo_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.meepo_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.meepo_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.meepo_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.meepo_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.meepo_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.meepo_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA2.meepo_sound_titles_Misc)
            }

            context.getString(R.string.Mirana) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_mirana
                soundUriListAttack.addAll(soundArraysA2.mirana_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.mirana_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.mirana_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.mirana_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.mirana_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.mirana_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.mirana_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.mirana_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.mirana_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA2.mirana_sound_titles_Misc)
            }

            context.getString(R.string.Monkeyking) -> {
                val soundArraysA3 = SoundArraysA3(context)
                imageRes = miscArrays.board_header_mk
                soundUriListAttack.addAll(soundArraysA3.monkeyking_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA3.monkeyking_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA3.monkeyking_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA3.monkeyking_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA3.monkeyking_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA3.monkeyking_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA3.monkeyking_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA3.monkeyking_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA3.monkeyking_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA3.monkeyking_sound_titles_Misc)
            }

            context.getString(R.string.Morphling) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_morph
                soundUriListAttack.addAll(soundArraysA2.morphling_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.morphling_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.morphling_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.morphling_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.morphling_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.morphling_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.morphling_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.morphling_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.morphling_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA2.morphling_sound_titles_Misc)
            }

            context.getString(R.string.Nagasiren) -> {
                val soundArraysA2 = SoundArraysA2(context)
                imageRes = miscArrays.board_header_naga
                soundUriListAttack.addAll(soundArraysA2.nagasiren_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA2.nagasiren_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA2.nagasiren_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA2.nagasiren_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA2.nagasiren_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA2.nagasiren_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA2.nagasiren_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA2.nagasiren_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA2.nagasiren_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA2.nagasiren_sound_titles_Misc)
            }

            context.getString(R.string.Nyx) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_nyx
                soundUriListAttack.addAll(soundArraysA4.nyxassassin_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.nyxassassin_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.nyxassassin_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.nyxassassin_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.nyxassassin_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.nyxassassin_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.nyxassassin_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.nyxassassin_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.nyxassassin_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.nyxassassin_sound_titles_Misc)
            }

            context.getString(R.string.Pangolier) -> {
                val soundArraysA3 = SoundArraysA3(context)
                imageRes = miscArrays.board_header_pango
                soundUriListAttack.addAll(soundArraysA3.pangolier_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA3.pangolier_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA3.pangolier_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA3.pangolier_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA3.pangolier_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA3.pangolier_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA3.pangolier_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA3.pangolier_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA3.pangolier_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA3.pangolier_sound_titles_Misc)
            }

            context.getString(R.string.Phantomassassin) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_pa
                soundUriListAttack.addAll(soundArraysA4.phantomassassin_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.phantomassassin_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.phantomassassin_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.phantomassassin_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.phantomassassin_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.phantomassassin_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.phantomassassin_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.phantomassassin_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.phantomassassin_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.phantomassassin_sound_titles_Misc)
            }

            context.getString(R.string.Phantomlancer) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_pl
                soundUriListAttack.addAll(soundArraysA4.phantomlancer_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.phantomlancer_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.phantomlancer_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.phantomlancer_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.phantomlancer_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.phantomlancer_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.phantomlancer_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.phantomlancer_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.phantomlancer_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.phantomlancer_sound_titles_Misc)
            }

            context.getString(R.string.Razor) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_razor
                soundUriListAttack.addAll(soundArraysA4.razor_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.razor_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.razor_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.razor_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.razor_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.razor_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.razor_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.razor_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.razor_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.razor_sound_titles_Misc)
            }

            context.getString(R.string.Riki) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_riki
                soundUriListAttack.addAll(soundArraysA4.riki_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.riki_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.riki_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.riki_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.riki_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.riki_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.riki_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.riki_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.riki_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.riki_sound_titles_Misc)
            }

            context.getString(R.string.Shadowfiend) -> {
                val soundArraysA5 = SoundArraysA5(context)
                imageRes = miscArrays.board_header_sf
                soundUriListAttack.addAll(soundArraysA5.shadowfiend_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA5.shadowfiend_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA5.shadowfiend_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA5.shadowfiend_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA5.shadowfiend_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA5.shadowfiend_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA5.shadowfiend_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA5.shadowfiend_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA5.shadowfiend_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA5.shadowfiend_sound_titles_Misc)
            }

            context.getString(R.string.Slark) -> {
                val soundArraysA4 = SoundArraysA4(context)
                imageRes = miscArrays.board_header_slark
                soundUriListAttack.addAll(soundArraysA4.slark_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA4.slark_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA4.slark_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA4.slark_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA4.slark_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA4.slark_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA4.slark_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA4.slark_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA4.slark_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA4.slark_sound_titles_Misc)
            }

            context.getString(R.string.Sniper) -> {
                val soundArraysA5 = SoundArraysA5(context)
                imageRes = miscArrays.board_header_sniper
                soundUriListAttack.addAll(soundArraysA5.sniper_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA5.sniper_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA5.sniper_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA5.sniper_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA5.sniper_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA5.sniper_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA5.sniper_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA5.sniper_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA5.sniper_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA5.sniper_sound_titles_Misc)
            }

            context.getString(R.string.Spectre) -> {
                val soundArraysA5 = SoundArraysA5(context)
                imageRes = miscArrays.board_header_spectre
                soundUriListAttack.addAll(soundArraysA5.spectre_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA5.spectre_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA5.spectre_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA5.spectre_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA5.spectre_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA5.spectre_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA5.spectre_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA5.spectre_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA5.spectre_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA5.spectre_sound_titles_Misc)
            }

            context.getString(R.string.Templarassassin) -> {
                val soundArraysA5 = SoundArraysA5(context)
                imageRes = miscArrays.board_header_ta
                soundUriListAttack.addAll(soundArraysA5.templarassassin_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA5.templarassassin_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA5.templarassassin_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA5.templarassassin_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA5.templarassassin_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA5.templarassassin_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA5.templarassassin_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA5.templarassassin_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA5.templarassassin_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA5.templarassassin_sound_titles_Misc)
            }

            context.getString(R.string.Terrorblade) -> {
                val soundArraysA5 = SoundArraysA5(context)
                imageRes = miscArrays.board_header_terrorblade
                soundUriListAttack.addAll(soundArraysA5.terrorblade_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA5.terrorblade_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA5.terrorblade_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA5.terrorblade_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA5.terrorblade_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA5.terrorblade_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA5.terrorblade_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA5.terrorblade_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA5.terrorblade_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA5.terrorblade_sound_titles_Misc)
            }

            context.getString(R.string.Trollwarlord) -> {
                val soundArraysA6 = SoundArraysA6(context)
                imageRes = miscArrays.board_header_troll
                soundUriListAttack.addAll(soundArraysA6.trollwarlord_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA6.trollwarlord_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA6.trollwarlord_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA6.trollwarlord_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA6.trollwarlord_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA6.trollwarlord_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA6.trollwarlord_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA6.trollwarlord_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA6.trollwarlord_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA6.trollwarlord_sound_titles_Misc)
            }

            context.getString(R.string.Ursa) -> {
                val soundArraysA6 = SoundArraysA6(context)
                imageRes = miscArrays.board_header_ursa
                soundUriListAttack.addAll(soundArraysA6.ursa_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA6.ursa_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA6.ursa_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA6.ursa_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA6.ursa_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA6.ursa_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA6.ursa_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA6.ursa_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA6.ursa_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA6.ursa_sound_titles_Misc)
            }

            context.getString(R.string.Vengefulspirit) -> {
                val soundArraysA6 = SoundArraysA6(context)
                imageRes = miscArrays.board_header_vengeful
                soundUriListAttack.addAll(soundArraysA6.vengefulspirit_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA6.vengefulspirit_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA6.vengefulspirit_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA6.vengefulspirit_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA6.vengefulspirit_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA6.vengefulspirit_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA6.vengefulspirit_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA6.vengefulspirit_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA6.vengefulspirit_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA6.vengefulspirit_sound_titles_Misc)
            }

            context.getString(R.string.Venomancer) -> {
                val soundArraysA6 = SoundArraysA6(context)
                imageRes = miscArrays.board_header_venomancer
                soundUriListAttack.addAll(soundArraysA6.venomancer_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA6.venomancer_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA6.venomancer_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA6.venomancer_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA6.venomancer_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA6.venomancer_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA6.venomancer_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA6.venomancer_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA6.venomancer_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA6.venomancer_sound_titles_Misc)
            }

            context.getString(R.string.Viper) -> {
                val soundArraysA6 = SoundArraysA6(context)
                imageRes = miscArrays.board_header_viper
                soundUriListAttack.addAll(soundArraysA6.viper_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA6.viper_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA6.viper_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA6.viper_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA6.viper_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA6.viper_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA6.viper_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA6.viper_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA6.viper_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA6.viper_sound_titles_Misc)
            }

            context.getString(R.string.Weaver) -> {
                val soundArraysA6 = SoundArraysA6(context)
                imageRes = miscArrays.board_header_weaver
                soundUriListAttack.addAll(soundArraysA6.weaver_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysA6.weaver_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysA6.weaver_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysA6.weaver_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysA6.weaver_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysA6.weaver_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysA6.weaver_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysA6.weaver_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysA6.weaver_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysA6.weaver_sound_titles_Misc)
            }

            context.getString(R.string.Ancientapparition) -> {
                val soundArraysS1 = SoundArraysS1(context)
                imageRes = miscArrays.board_header_ancient
                soundUriListAttack.addAll(soundArraysS1.ancientapparition_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysS1.ancientapparition_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysS1.ancientapparition_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysS1.ancientapparition_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysS1.ancientapparition_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysS1.ancientapparition_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysS1.ancientapparition_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysS1.ancientapparition_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysS1.ancientapparition_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysS1.ancientapparition_sound_titles_Misc)
            }

            context.getString(R.string.Bane) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_bane
                soundUriListAttack.addAll(soundArraysI1.bane_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.bane_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.bane_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.bane_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.bane_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.bane_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.bane_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.bane_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.bane_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.bane_sound_titles_Misc)
            }

            context.getString(R.string.Batrider) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_batrider
                soundUriListAttack.addAll(soundArraysI1.batrider_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.batrider_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.batrider_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.batrider_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.batrider_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.batrider_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.batrider_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.batrider_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.batrider_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.batrider_sound_titles_Misc)
            }

            context.getString(R.string.Chen) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_chen
                soundUriListAttack.addAll(soundArraysI1.chen_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.chen_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.chen_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.chen_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.chen_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.chen_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.chen_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.chen_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.chen_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.chen_sound_titles_Misc)
            }

            context.getString(R.string.Crystalmaiden) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_cm
                soundUriListAttack.addAll(soundArraysI1.crystalmaiden_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.crystalmaiden_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.crystalmaiden_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.crystalmaiden_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.crystalmaiden_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.crystalmaiden_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.crystalmaiden_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.crystalmaiden_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.crystalmaiden_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.crystalmaiden_sound_titles_Misc)
            }

            context.getString(R.string.Darkseer) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_ds
                soundUriListAttack.addAll(soundArraysI1.darkseer_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.darkseer_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.darkseer_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.darkseer_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.darkseer_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.darkseer_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.darkseer_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.darkseer_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.darkseer_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.darkseer_sound_titles_Misc)
            }

            context.getString(R.string.Darkwillow) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_dw
                soundUriListAttack.addAll(soundArraysI1.darkwillow_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.darkwillow_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.darkwillow_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.darkwillow_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.darkwillow_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.darkwillow_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.darkwillow_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.darkwillow_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.darkwillow_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.darkwillow_sound_titles_Misc)
            }

            context.getString(R.string.Dazzle) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_dazzle
                soundUriListAttack.addAll(soundArraysI1.dazzle_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.dazzle_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.dazzle_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.dazzle_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.dazzle_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.dazzle_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.dazzle_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.dazzle_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.dazzle_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.dazzle_sound_titles_Misc)
            }

            context.getString(R.string.Deathprophet) -> {
                val soundArraysI1 = SoundArraysI1(context)
                imageRes = miscArrays.board_header_dp
                soundUriListAttack.addAll(soundArraysI1.deathprophet_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI1.deathprophet_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI1.deathprophet_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI1.deathprophet_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI1.deathprophet_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI1.deathprophet_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI1.deathprophet_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI1.deathprophet_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI1.deathprophet_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI1.deathprophet_sound_titles_Misc)
            }

            context.getString(R.string.Disruptor) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_disruptor
                soundUriListAttack.addAll(soundArraysI2.disruptor_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.disruptor_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.disruptor_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.disruptor_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.disruptor_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.disruptor_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.disruptor_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.disruptor_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.disruptor_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.disruptor_sound_titles_Misc)
            }

            context.getString(R.string.Enchantress) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_enchantress
                soundUriListAttack.addAll(soundArraysI2.enchantress_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.enchantress_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.enchantress_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.enchantress_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.enchantress_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.enchantress_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.enchantress_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.enchantress_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.enchantress_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.enchantress_sound_titles_Misc)
            }

            context.getString(R.string.Enigma) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_enigma
                soundUriListAttack.addAll(soundArraysI2.enigma_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.enigma_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.enigma_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.enigma_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.enigma_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.enigma_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.enigma_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.enigma_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.enigma_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.enigma_sound_titles_Misc)
            }

            context.getString(R.string.Invoker) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_invoker
                soundUriListAttack.addAll(soundArraysI2.invoker_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.invoker_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.invoker_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.invoker_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.invoker_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.invoker_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.invoker_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.invoker_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.invoker_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.invoker_sound_titles_Misc)
            }

            context.getString(R.string.Jakiro) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_jakiro
                soundUriListAttack.addAll(soundArraysI2.jakiro_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.jakiro_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.jakiro_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.jakiro_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.jakiro_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.jakiro_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.jakiro_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.jakiro_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.jakiro_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.jakiro_sound_titles_Misc)
            }

            context.getString(R.string.Keeperofthelight) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_kotl
                soundUriListAttack.addAll(soundArraysI2.keeperofthelight_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.keeperofthelight_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.keeperofthelight_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.keeperofthelight_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.keeperofthelight_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.keeperofthelight_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.keeperofthelight_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.keeperofthelight_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.keeperofthelight_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.keeperofthelight_sound_titles_Misc)
            }

            context.getString(R.string.Leshrac) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_leshrac
                soundUriListAttack.addAll(soundArraysI2.leshrac_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.leshrac_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.leshrac_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.leshrac_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.leshrac_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.leshrac_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.leshrac_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.leshrac_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.leshrac_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.leshrac_sound_titles_Misc)
            }

            context.getString(R.string.Lich) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_lich
                soundUriListAttack.addAll(soundArraysI2.lich_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.lich_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.lich_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.lich_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.lich_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.lich_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.lich_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.lich_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.lich_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.lich_sound_titles_Misc)
            }

            context.getString(R.string.Lina) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_lina
                soundUriListAttack.addAll(soundArraysI2.lina_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.lina_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.lina_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.lina_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.lina_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.lina_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.lina_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.lina_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.lina_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.lina_sound_titles_Misc)
            }

            context.getString(R.string.Lion) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_lion
                soundUriListAttack.addAll(soundArraysI2.lion_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.lion_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.lion_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.lion_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.lion_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.lion_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.lion_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.lion_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.lion_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.lion_sound_titles_Misc)
            }

            context.getString(R.string.Naturesprophet) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_np
                soundUriListAttack.addAll(soundArraysI2.naturesprophet_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.naturesprophet_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.naturesprophet_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.naturesprophet_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.naturesprophet_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.naturesprophet_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.naturesprophet_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.naturesprophet_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.naturesprophet_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.naturesprophet_sound_titles_Misc)
            }

            context.getString(R.string.Necrophos) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_necro
                soundUriListAttack.addAll(soundArraysI2.necrophos_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.necrophos_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.necrophos_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.necrophos_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.necrophos_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.necrophos_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.necrophos_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.necrophos_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.necrophos_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.necrophos_sound_titles_Misc)
            }

            context.getString(R.string.Ogremagi) -> {
                val soundArraysI2 = SoundArraysI2(context)
                imageRes = miscArrays.board_header_ogre
                soundUriListAttack.addAll(soundArraysI2.ogremagi_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI2.ogremagi_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI2.ogremagi_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI2.ogremagi_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI2.ogremagi_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI2.ogremagi_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI2.ogremagi_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI2.ogremagi_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI2.ogremagi_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI2.ogremagi_sound_titles_Misc)
            }

            context.getString(R.string.Oracle) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_oracle
                soundUriListAttack.addAll(soundArraysI3.oracle_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.oracle_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.oracle_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.oracle_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.oracle_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.oracle_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.oracle_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.oracle_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.oracle_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.oracle_sound_titles_Misc)
            }

            context.getString(R.string.Outworlddevourer) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_od
                soundUriListAttack.addAll(soundArraysI3.outworlddevourer_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.outworlddevourer_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.outworlddevourer_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.outworlddevourer_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.outworlddevourer_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.outworlddevourer_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.outworlddevourer_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.outworlddevourer_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.outworlddevourer_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.outworlddevourer_sound_titles_Misc)
            }

            context.getString(R.string.Puck) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_puck
                soundUriListAttack.addAll(soundArraysI3.puck_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.puck_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.puck_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.puck_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.puck_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.puck_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.puck_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.puck_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.puck_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.puck_sound_titles_Misc)
            }

            context.getString(R.string.Pugna) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_pugna
                soundUriListAttack.addAll(soundArraysI3.pugna_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.pugna_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.pugna_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.pugna_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.pugna_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.pugna_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.pugna_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.pugna_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.pugna_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.pugna_sound_titles_Misc)
            }

            context.getString(R.string.Queenofpain) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_qop
                soundUriListAttack.addAll(soundArraysI3.queenofpain_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.queenofpain_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.queenofpain_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.queenofpain_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.queenofpain_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.queenofpain_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.queenofpain_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.queenofpain_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.queenofpain_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.queenofpain_sound_titles_Misc)
            }

            context.getString(R.string.Rubick) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_rubick
                soundUriListAttack.addAll(soundArraysI3.rubick_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.rubick_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.rubick_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.rubick_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.rubick_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.rubick_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.rubick_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.rubick_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.rubick_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.rubick_sound_titles_Misc)
            }

            context.getString(R.string.Shadowdemon) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_sd
                soundUriListAttack.addAll(soundArraysI3.shadowdemon_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.shadowdemon_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.shadowdemon_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.shadowdemon_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.shadowdemon_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.shadowdemon_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.shadowdemon_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.shadowdemon_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.shadowdemon_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.shadowdemon_sound_titles_Misc)
            }

            context.getString(R.string.Shadowshaman) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_ss
                soundUriListAttack.addAll(soundArraysI3.shadowshaman_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.shadowshaman_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.shadowshaman_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.shadowshaman_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.shadowshaman_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.shadowshaman_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.shadowshaman_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.shadowshaman_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.shadowshaman_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.shadowshaman_sound_titles_Misc)
            }

            context.getString(R.string.Silencer) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_silencer
                soundUriListAttack.addAll(soundArraysI3.silencer_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.silencer_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.silencer_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.silencer_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.silencer_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.silencer_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.silencer_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.silencer_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.silencer_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.silencer_sound_titles_Misc)
            }

            context.getString(R.string.Skywrathmage) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_sm
                soundUriListAttack.addAll(soundArraysI3.skywrathmage_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.skywrathmage_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.skywrathmage_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.skywrathmage_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.skywrathmage_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.skywrathmage_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.skywrathmage_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.skywrathmage_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.skywrathmage_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.skywrathmage_sound_titles_Misc)
            }

            context.getString(R.string.Stormspirit) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_storm
                soundUriListAttack.addAll(soundArraysI3.stormspirit_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.stormspirit_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.stormspirit_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.stormspirit_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.stormspirit_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.stormspirit_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.stormspirit_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.stormspirit_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.stormspirit_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.stormspirit_sound_titles_Misc)
            }

            context.getString(R.string.Techies) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_techies
                soundUriListAttack.addAll(soundArraysI3.techies_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.techies_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.techies_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.techies_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.techies_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.techies_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.techies_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.techies_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.techies_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.techies_sound_titles_Misc)
            }

            context.getString(R.string.Tinker) -> {
                val soundArraysI3 = SoundArraysI3(context)
                imageRes = miscArrays.board_header_tinker
                soundUriListAttack.addAll(soundArraysI3.tinker_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI3.tinker_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI3.tinker_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI3.tinker_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI3.tinker_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI3.tinker_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI3.tinker_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI3.tinker_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI3.tinker_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI3.tinker_sound_titles_Misc)
            }

            context.getString(R.string.Visage) -> {
                val soundArraysI4 = SoundArraysI4(context)
                imageRes = miscArrays.board_header_visage
                soundUriListAttack.addAll(soundArraysI4.visage_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI4.visage_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI4.visage_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI4.visage_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI4.visage_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI4.visage_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI4.visage_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI4.visage_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI4.visage_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI4.visage_sound_titles_Misc)
            }

            context.getString(R.string.Warlock) -> {
                val soundArraysI4 = SoundArraysI4(context)
                imageRes = miscArrays.board_header_warlock
                soundUriListAttack.addAll(soundArraysI4.warlock_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI4.warlock_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI4.warlock_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI4.warlock_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI4.warlock_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI4.warlock_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI4.warlock_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI4.warlock_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI4.warlock_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI4.warlock_sound_titles_Misc)
            }

            context.getString(R.string.Windranger) -> {
                val soundArraysI4 = SoundArraysI4(context)
                imageRes = miscArrays.board_header_wr
                soundUriListAttack.addAll(soundArraysI4.windranger_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI4.windranger_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI4.windranger_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI4.windranger_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI4.windranger_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI4.windranger_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI4.windranger_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI4.windranger_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI4.windranger_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI4.windranger_sound_titles_Misc)
            }

            context.getString(R.string.Winterwyvern) -> {
                val soundArraysI4 = SoundArraysI4(context)
                imageRes = miscArrays.board_header_ww
                soundUriListAttack.addAll(soundArraysI4.winterwyvern_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI4.winterwyvern_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI4.winterwyvern_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI4.winterwyvern_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI4.winterwyvern_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI4.winterwyvern_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI4.winterwyvern_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI4.winterwyvern_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI4.winterwyvern_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI4.winterwyvern_sound_titles_Misc)
            }

            context.getString(R.string.Witchdoctor) -> {
                val soundArraysI4 = SoundArraysI4(context)
                imageRes = miscArrays.board_header_wd
                soundUriListAttack.addAll(soundArraysI4.witchdoctor_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI4.witchdoctor_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI4.witchdoctor_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI4.witchdoctor_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI4.witchdoctor_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI4.witchdoctor_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI4.witchdoctor_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI4.witchdoctor_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI4.witchdoctor_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI4.witchdoctor_sound_titles_Misc)
            }

            context.getString(R.string.Zeus) -> {
                val soundArraysI4 = SoundArraysI4(context)
                imageRes = miscArrays.board_header_zeus
                soundUriListAttack.addAll(soundArraysI4.zeus_sound_res_Attacks)
                soundTitlesListAttack.addAll(soundArraysI4.zeus_sound_titles_Attacks)
                soundUriListAbilities.addAll(soundArraysI4.zeus_sound_res_Abilities)
                soundTitlesListAbilities.addAll(soundArraysI4.zeus_sound_titles_Abilities)
                soundUriListHeroRelated.addAll(soundArraysI4.zeus_sound_res_Hero_Related)
                soundTitlesListHeroRelated.addAll(soundArraysI4.zeus_sound_titles_Hero_Related)
                soundUriListItems.addAll(soundArraysI4.zeus_sound_res_Items)
                soundTitlesListItems.addAll(soundArraysI4.zeus_sound_titles_Items)
                soundUriListMisc.addAll(soundArraysI4.zeus_sound_res_Misc)
                soundTitlesListMisc.addAll(soundArraysI4.zeus_sound_titles_Misc)
            }

            else -> {
                val soundArraysMisc = SoundArraysMisc(context)
                imageRes = miscArrays.ti7_board_header
                soundUriListAttack.addAll(soundArraysMisc.ti7_sound_res)
                soundTitlesListAttack.addAll(soundArraysMisc.ti7_sound_titles)
            }
        }

        (0 until soundUriListAttack.size).mapTo(soundsListAttack) { Sound(soundUriListAttack[it], soundTitlesListAttack[it]) }
        (0 until soundUriListAttackMorphed.size).mapTo(soundsListAttackMorphed) { Sound(soundUriListAttackMorphed[it], soundTitlesListAttack[it]) }

        (0 until soundUriListAbilities.size).mapTo(soundsListAbilities) { Sound(soundUriListAbilities[it], soundTitlesListAbilities[it]) }
        (0 until soundUriListAbilitiesMorphed.size).mapTo(soundsListAbilitiesMorphed) { Sound(soundUriListAbilitiesMorphed[it], soundTitlesListAbilities[it]) }

        (0 until soundUriListItems.size).mapTo(soundsListItems) { Sound(soundUriListItems[it], soundTitlesListItems[it]) }
        (0 until soundUriListItemsMorphed.size).mapTo(soundsListItemsMorphed) { Sound(soundUriListItemsMorphed[it], soundTitlesListItems[it]) }

        (0 until soundUriListGame.size).mapTo(soundsListGame) { Sound(soundUriListGame[it], soundTitlesListGame[it]) }
        (0 until soundUriListGameMorphed.size).mapTo(soundsListGameMorphed) { Sound(soundUriListGameMorphed[it], soundTitlesListGame[it]) }

        (0 until soundUriListHeroRelated.size).mapTo(soundsListHeroRelated) { Sound(soundUriListHeroRelated[it], soundTitlesListHeroRelated[it]) }
        (0 until soundUriListHeroRelatedMorphed.size).mapTo(soundsListHeroRelatedMorphed) { Sound(soundUriListHeroRelatedMorphed[it], soundTitlesListHeroRelated[it]) }

        (0 until soundUriListMisc.size).mapTo(soundsListMisc) { Sound(soundUriListMisc[it], soundTitlesListMisc[it]) }
        (0 until soundUriListMiscMorphed.size).mapTo(soundsListMiscMorphed) { Sound(soundUriListMiscMorphed[it], soundTitlesListMisc[it]) }

        val bundle = Bundle()
        bundle.putInt("imageRes", imageRes)
        bundle.putSerializable("soundsListAttack", soundsListAttack)
        bundle.putSerializable("soundsListAttackMorphed", soundsListAttackMorphed)
        bundle.putSerializable("soundsListAbilities", soundsListAbilities)
        bundle.putSerializable("soundsListAbilitiesMorphed", soundsListAbilitiesMorphed)
        bundle.putSerializable("soundsListItems", soundsListItems)
        bundle.putSerializable("soundsListItemsMorphed", soundsListItemsMorphed)
        bundle.putSerializable("soundsListGame", soundsListGame)
        bundle.putSerializable("soundsListGameMorphed", soundsListGameMorphed)
        bundle.putSerializable("soundsListHeroRelated", soundsListHeroRelated)
        bundle.putSerializable("soundsListHeroRelatedMorphed", soundsListHeroRelatedMorphed)
        bundle.putSerializable("soundsListMisc", soundsListMisc)
        bundle.putSerializable("soundsListMiscMorphed", soundsListMiscMorphed)
        return bundle
    }

    override fun onPostExecute(result: Bundle?) {
        listener.onAssignHeroesCompleted(false, result!!)
    }


}