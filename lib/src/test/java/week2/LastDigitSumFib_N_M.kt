package week2

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val s = Scanner(System.`in`)
    val n = s.nextLong()
    val m = s.nextLong()
    println(lastDigitFibSumNumberNM(n, m))

}

fun lastDigitFibSumNumberNMTester(n : Long, m : Long) : Long{

    var sumFibs = 0L

    for(i in m .. n){
        sumFibs = ( sumFibs + fib(i) % 10) % 10
    }

    return sumFibs
}

fun lastDigitFibSumNumberNM(mp : Long, np : Long) : Long{

    val n = np % 60
    val m = mp % 60

    when(n){
        0L -> return 0
        1L -> return 1L
    }

    var a = 0L
    var b = 1L
    var sumFibs = 0L
    var curr = -1L

    for(i in 2 .. n){
        curr = (a + b) % 10
        if(i >= m){
            sumFibs = (sumFibs + curr) % 10
        }

        a = b
        b = curr
    }

    return sumFibs
}

class LastDigitoftheSumofFibonacciNumbersTestNM{


    @Test
    fun t2(){
        for(m in 0 .. 10){
            val n = m + Random().nextInt(5)
            Assert.assertEquals(lastDigitFibSumNumberNMTester(m.toLong(), n.toLong()), lastDigitFibSumNumberNM(m.toLong(), n.toLong()))
        }

    }

    @Test
    fun t1_1(){
        Assert.assertEquals(1, lastDigitFibSumNumberNMTester(3, 7))
        Assert.assertEquals(5, lastDigitFibSumNumberNMTester(10, 10))
    }

    @Test
    fun t1(){
        Assert.assertEquals(1, lastDigitFibSumNumberNM(3, 7))
        Assert.assertEquals(5, lastDigitFibSumNumberNM(10, 10))
    }

    @Test
    fun o1(){
        val a = arrayListOf("01 RH INTRO 2.mp3",
                "Right Hand Finger Pattern.mp3",
                "Right Hand Finger Pattern Faster.mp3",
                "Left Hand Finger Pattern.mp3",
                "Left Hand Finger Pattern Faster.mp3",
                "Note Values Whole Notes 1.mp3",
                "Note Values Half Notes 1.mp3",
                "Note Values Quarter Notes 1.mp3",
                "Hot Cross Buns.mp3",
                "Hot Cross Buns Faster.mp3",
                "By The Silvery Moonlight.mp3",
                "By The Silvery Moonlight Faster.mp3",
                "Rain Rain Go Away.mp3",
                "Rain Rain Go Away Faster.mp3",
                "Go Tell Aunt Rhody.mp3",
                "Go Tell Aunt Rhody Faster.mp3",
                "Aura Lee 1.mp3",
                "Aura Lee 1 Faster 1.mp3",
                "Jingle Bells.mp3",
                "Jingle Bells Complete.mp3",
                "Jingle Bells Play Along.mp3",
                "Good King Wenceslas.mp3",
                "Good King Wenceslas Complete.mp3",
                "Good King Wenceslas Play Along.mp3",
                "White Key Finger Flexing.mp3",
                "White Key Finger Flexing Faster.mp3",
                "White Key Finger Flexing ex 2.mp3",
                "White Key Finger Flexing ex 2 Faster.mp3",
                "A Tisket a Tasket.mp3",
                "A Tisket a Tasket Faster.mp3",
                "I Saw Three Ships.mp3",
                "I Saw Three Ships Faster 1.mp3",
                "Oh When The Saints.mp3",
                "Oh When The Saints Faster.mp3",
                "Fais Dodo.mp3",
                "Fais Dodo Faster.mp3");

        a.sort()
        a.forEach { println(it) }
    }



}

/*

<div id="flex__2_contentwrapper" class="contentwrapper" style="position: relative; top: -2340px; width: 100%; display: block; padding: 0px; left: 0px;">
						<!--- database --->

/resources/audios/01 Rock House Introduction.mp3
/resources/audios/02 Names of the Open Strings and Tu.mp3
/resources/audios/03 Open String Picking Pattern.mp3
/resources/audios/04 Your First Chords.mp3
/resources/audios/05 Chord Picking Pattern.mp3
/resources/audios/06 Strumming Chords Major 1 - 5 Pro.mp3
/resources/audios/07 Strumming Chords Major 1 - 5 Pro.mp3
/resources/audios/08 Strumming Chords Major 1 - 5 Pro.mp3
/resources/audios/09 Strumming Chords Major 1 - 5 Pro.mp3
/resources/audios/10 Strumming Chords Major 1 - 5 Pro.mp3
/resources/audios/11 Strumming Chords Major 1 - 5 Pro.mp3
/resources/audios/12 Minor Chords.mp3
/resources/audios/13 Minor 1 - 5 Progression -.mp3
/resources/audios/14 Minor 1 - 5 Progression - Play A.mp3
/resources/audios/15 Tablature Riffs.mp3
/resources/audios/16 Aura Lee.mp3
/resources/audios/17 Power Chords.mp3
/resources/audios/18 Power Chord 1 - 4 - 5 Progressio.mp3
/resources/audios/19 Power Chord 1 - 4 - 5 Progressio.mp3
/resources/audios/20 Closed Chord 1 - 4 - 5  Progress.mp3
/resources/audios/21 Closed Chord 1 - 4 - 5  Progress.mp3
/resources/audios/22 Rockin the Bells.mp3
/resources/audios/23 Rockin the Bells Play Along.mp3
/resources/audios/24 Blues In A.mp3
/resources/audios/25 Blues In A-Play Along.mp3
/resources/audios/25 Blues In A-Play Along.mp3
/resources/audios/26 The Shuffle Feel.mp3
/resources/audios/27 The Shuffle Feel-Play Along.mp3
/resources/audios/28 Single Note Riffs.mp3
/resources/audios/29 The 4 Chord Song 1 - 5 - 6 - 4 _.mp3
/resources/audios/30 The 4 Chord Song 1 - 5 - 6 - 4 _.mp3
/resources/audios/31 Picking Exercise.mp3
/resources/audios/32 Eighth Notes.mp3
/resources/audios/33 Chord Picking Pattern #2.mp3
/resources/audios/34 Chord Picking Pattern #2 - Play_.mp3
/resources/audios/35 Eighth Note Riffs Example 1.mp3
/resources/audios/36 Eighth Note Riffs Example 2.mp3
/resources/audios/37 Open Chords G - Cadd9 - D.mp3
/resources/audios/38 A Day at the Beach 1 - 4 - 5 Ope.mp3
/resources/audios/39 A Day at the Beach 1 - 4 - 5 Ope.mp3
/resources/audios/40 Blues Riff Rhythm.mp3
/resources/audios/41 Blues Riff Rhythm-Play Along.mp3
/resources/audios/42 Finger Flexing.mp3
/resources/audios/43 Single Note Riffs #2.mp3
/resources/audios/44 The Four Chord Song Part 2.mp3
/resources/audios/45 The Four Chord Song Part 2  - UP.mp3
/resources/audios/46 Minor Pentatonic Scale 1st Posit.mp3
/resources/audios/47 Minor Pentatonic Lead Pattern.mp3
/resources/audios/48 Minor Pentatonic Scale Riffs.mp3
/resources/audios/49 Classical Melody-Ode To Joy.mp3
/resources/audios/50 Classical Melody-Ode To Joy-Play.mp3
/resources/audios/51 The F Major Chord.mp3
/resources/audios/52 Royal Rock 1 - 5 - 6 - 4 Progres.mp3
/resources/audios/53 Royal Rock 1 - 5 - 6 - 4 Progres.mp3
/resources/audios/54 Song Riff.mp3
/resources/audios/55 Minor Pentatonic Scales Position.mp3
/resources/audios/56 Minor Pentatonic Lead Pattern Po.mp3
/resources/audios/57 Blue Velvet 1 - 6 - 3 - 5 Progre.mp3
/resources/audios/58 Blue Velvet 1 - 6 - 3 - 5 Progre.mp3
/resources/audios/59 Minor Pentatonic Triplet Lead Pa.mp3
/resources/audios/60 Street of Dreams 2 - 4 - 1 - 5 P.mp3
/resources/audios/61 Street of Dreams - Up Tempo.mp3
/resources/audios/62 Finger Flexing 2.mp3
/resources/audios/63 Single Note Riff Rhythm.mp3
/resources/audios/64 Single Note Riff Rhythm Play Alo.mp3
/resources/audios/65 Lead Techniques Bending.mp3
/resources/audios/66 Lead Techniques-Hammerons.mp3
/resources/audios/67 Complete Blues Lead.mp3
/resources/audios/68 Complete Blues Lead-Full Band.mp3
/resources/audios/69 Complete Blues Lead-Play Along.mp3
/resources/audios/70 More Minor Chords.mp3
/resources/audios/71 Black Pearl.mp3
/resources/audios/72 Black Pearl-Play Along.mp3
/resources/audios/73 Song Riff 2.mp3
/resources/audios/74 Epic Sun - 1 - 5 - 6 - 4 Progres.mp3
/resources/audios/75 Epic Sun 1 - 5 - 6 - 4 Progressi.mp3
/resources/audios/76 Minor Pentatonic Scale Positions.mp3
/resources/audios/77 Applying the Pentatonic Scale.mp3
/resources/audios/78 Rockit Center 6 - 4 - 1 - 5 Prog.mp3
/resources/audios/79 RockIt Center 6 - 4 - 1 - 5 Prog.mp3
/resources/audios/80 Lead Techniques Pull Offs.mp3
/resources/audios/81 The High Road - Single Note Riff.mp3
/resources/audios/82 The High Road - Single Note Riff.mp3
/resources/audios/83 Lead Riffs.mp3
/resources/audios/84 Rock Climbing 3 - 5 - 6 - 1 Prog.mp3
/resources/audios/85 Rock Climbing 3 - 5 - 6 - 1 Prog.mp3
/resources/audios/86 The Star Spangled Banner.mp3
/resources/audios/87 The Star Spangled Banner Play Al.mp3
/resources/audios/88 Lead Techniques Hammer Ons &amp;  Pu.mp3
/resources/audios/89 Complete Rhythm &amp; Lead- Rhythm B.mp3
/resources/audios/90 Complete Rhythm &amp; Lead-Rhythm.mp3
/resources/audios/91 Complete Rhythm &amp; Lead-Bass and_.mp3
/resources/audios/92 Complete Rhythm &amp; Lead- Lead Bre.mp3
/resources/audios/93 Complete Rhythm &amp; Lead-Rhythm an.mp3
/resources/audios/94 Complete Rhythm &amp; Lead-Rhythm.mp3
/resources/audios/02 My MoJo is Back - Shuffle Blues Rhythm 2.mp3
/resources/audios/03 My MoJo is Back - Shuffle Blues Rhythm 2.mp3
/resources/audios/04 Bending 2.mp3
/resources/audios/05 Lead Riffs with Bending 2.mp3
/resources/audios/06 Sixteenth Notes 2.mp3
/resources/audios/07 Speed Demon Exercise 2.mp3
/resources/audios/08 Sixteenth Note Lead Pattern 1st Position 2.mp3
/resources/audios/09 Sixteenth Note lead Pattern 2nd Position 2.mp3
/resources/audios/10 Double Stops - Double Stop Blues 2.mp3
/resources/audios/11 Double Stops - Double Stop Blues play along 2.mp3
/resources/audios/12 Double Stops - The Crew 2.mp3
/resources/audios/13 Double Stops - The Crew - Play Along 2.mp3
/resources/audios/14 Minor Pentatonic Scales Key of E 1st Position 2.mp3
/resources/audios/15 Minor Pentatonic Scales Key of E 2nd Position 2.mp3
/resources/audios/16 Minor Pentatonic Scales Key of E 3rd Position 2.mp3
/resources/audios/17 Minor Pentatonic Scales Key of E 4th Position 2.mp3
/resources/audios/18 Minor Pentatonic Scales Key of E 5th Position 2.mp3
/resources/audios/19 Minor Pentatonic Scales Key of E 1st Position Octave 2.mp3
/resources/audios/20 Lead Patterns in the Key of E 2.mp3
/resources/audios/21 Lead Patterns in the Key of E - 2nd Position Follow Pattern 2.mp3
/resources/audios/22 Lead Patterns in the Key of E - 1st Position Triplet Pattern 2.mp3
/resources/audios/23 Remeber the Day 6 - 4 - 1 - 5 Progression 2.mp3
/resources/audios/24 Remeber the Day 6 - 4 - 1 - 5 Progression - Play Along 2.mp3
/resources/audios/25 Riff Challenge - Riff 1 2.mp3
/resources/audios/26 Riff Challenge - Riff 2 2.mp3
/resources/audios/27 Riff Challenge - Riff 3 2.mp3
/resources/audios/28 Riff Challenge - Riff 4 2.mp3
/resources/audios/29 Riff Challenge - Riff 5 2.mp3
/resources/audios/30 Bar Chord 1 - 4 - 5 Progression 2.mp3
/resources/audios/31 Bar Chord 1 - 4 - 5 Progression - Play Along 2.mp3
/resources/audios/32 Bar Chord Rhythm Ramone 2.mp3
/resources/audios/33 Bar Chord Rhythm Ramone - Play Along 2.mp3
/resources/audios/34 Song Riff Rev It Up 2.mp3
/resources/audios/35 Song Riff Rev It Up - Play Along 2.mp3
/resources/audios/36 Triplet Timing 2.mp3
/resources/audios/37 Complete Progressions &amp; Melody - House of the Rising Sun 2.mp3
/resources/audios/38 Complete Progressions &amp; Melody - House of the Rising Sun - Play Along Rhythm 2.mp3
/resources/audios/39 Complete Progressions &amp; Melody - House of the Rising Sun - Play Along 2.mp3
/resources/audios/40 Blues Scales Key of E - 1st Position 2.mp3
/resources/audios/41 Blues Scales Key of E - 2nd Position 2.mp3
/resources/audios/42 Blues Scales Key of E - 3rd Position 2.mp3
/resources/audios/42 Blues Scales Key of E - 3rd Position 2.mp3
/resources/audios/44 Blues Scales Key of E - 5th Position 2.mp3
/resources/audios/45 Blues Scales Key of E - 1st Position Open 2.mp3
/resources/audios/46 Full Blues Rhythm - Turn Things Around 2.mp3
/resources/audios/47 Full Blues Rhythm - Turn Things Around - Play Along 2.mp3
/resources/audios/48 Slides 2.mp3
/resources/audios/50 Blues Lead - Play Along 2.mp3
/resources/audios/51 Greensleeves - Melody 2.mp3
/resources/audios/52 Greensleeves - Hybrid Picking Rhyhtm 2.mp3
/resources/audios/53 C Major Scales One Octave Patterns 2.mp3
/resources/audios/54 6 String C Major Scale Patterns - 1st Position 2.mp3
/resources/audios/55 6 String C Major Scale Patterns - 2nd Position 2.mp3
/resources/audios/56 6 String C Major Scale Patterns - 3rd Position 2.mp3
/resources/audios/57 6 String C Major Scale Patterns - 4th Position 2.mp3
/resources/audios/58 6 String C Major Scale Patterns - 5th Position 2.mp3
/resources/audios/59 Cannon 2.mp3
/resources/audios/60 Cannon Rhyhtm &amp; Melody 2.mp3
/resources/audios/61 Cannon Rhyhtm &amp; Melody - Play Along 2.mp3
/resources/audios/62 The Mexican Snake Song 2.mp3
/resources/audios/63 The Mexican Snake Song - Play Along 2.mp3
/resources/audios/64 Major Scale Triplet Lead Pattern 2.mp3
/resources/audios/65 VooDoo Girl 6 - 2 - 1 - 5 Progression 2.mp3
/resources/audios/66 VooDoo Girl 6 - 2 - 1 - 5 Progression - Play Along 2.mp3
/resources/audios/67 Arpeggops - Major 2.mp3
/resources/audios/68 Arpeggops - Minor 2.mp3
/resources/audios/69 Sweep Picking Exercise 2.mp3
/resources/audios/70 Sungle Note Riffs 2.mp3
/resources/audios/71 Yeah Mon - Reggae 1 - 4 - 5  Progression 2.mp3
/resources/audios/72 Yeah Mon - Reggae 1 - 4 - 5  Progression - Play Along 2.mp3
/resources/audios/73 Naturak Minor Scales Key of A - !st Position 2.mp3
/resources/audios/74 Naturak Minor Scales Key of A - 2nd Position 2.mp3
/resources/audios/75 Naturak Minor Scales Key of A - 3rd Position 2.mp3
/resources/audios/76 Naturak Minor Scales Key of A - 4th Position 2.mp3
/resources/audios/77 Naturak Minor Scales Key of A - 5th Position 2.mp3
/resources/audios/78 Naturak Minor Scale Lead Pattern - 1st Position 2.mp3
/resources/audios/79 Hooked on Blues - Sliding Blues Riff 2.mp3
/resources/audios/80 7th Heaven - 1 - 4 - 5 Progression 2.mp3
/resources/audios/81 7th Heaven - 1 - 4 - 5 Progression - Play aAong 2.mp3
/resources/audios/82 Pentatonic Lateral Runs 2.mp3
/resources/audios/83 Riff Challenge #2 - Riff 1 2.mp3
/resources/audios/84 Riff Challenge #2 - Riff 2 2.mp3
/resources/audios/85 Riff Challenge #2 - Riff 3 2.mp3
/resources/audios/86 Drop D Tuning 2.mp3
/resources/audios/87 Mean Street Drop D Rhythm 2.mp3
/resources/audios/88 Mean Street Drop D Rhythm - Play Along 2.mp3
/resources/audios/89 The 2 - 5 - 1 Progression 2.mp3
/resources/audios/121 The 2 5 1 Progression-Play Along.mp3
/resources/audios/90 2 - 5 - 1 Lead Patterns 2.mp3
/resources/audios/123 The 2 5 1 Lead Pattern-Play Along.mp3
/resources/audios/100 Bi Dexteral Hammer Ons.mp3


 */
