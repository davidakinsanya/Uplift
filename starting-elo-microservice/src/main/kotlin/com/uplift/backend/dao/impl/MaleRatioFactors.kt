package com.uplift.backend.dao.impl

import com.uplift.backend.dto.StartingELO
import com.uplift.backend.dao.intrface.Factors
import com.uplift.backend.utils.ageFactor
import com.uplift.backend.utils.generateRandom

class MaleRatioFactors: Factors {
  
  companion object {
    private const val SQUAT_RATIO = 1.5
    private const val BENCH_RATIO = 1
    private const val DEADLIFT_RATIO = 2
  }
  
  override fun addBenchFactors(currentELO: Int,
                               startingELO: StartingELO,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val benchToBWRatio = startingELO.benchMax / currentWeight
  
    println("bch ratio:  + $benchToBWRatio")
  
    newELO += if (benchToBWRatio >= 0.8 && benchToBWRatio < BENCH_RATIO) generateRandom(10)
    else if (benchToBWRatio >= 1.1 && benchToBWRatio < 1.2) generateRandom(30)
    else if (benchToBWRatio >= 1.3 && benchToBWRatio < 1.3) generateRandom(40)
    else if (benchToBWRatio >= 1.3 && benchToBWRatio < 1.4) generateRandom(50)
    else if (benchToBWRatio >= 1.4 && benchToBWRatio < 1.5) generateRandom(60)
    else generateRandom(100)
  
    return ageFactor(startingELO, newELO)
  }
  
  override fun addSquatFactors(currentELO: Int,
                               startingELO: StartingELO,
                               currentWeight: Float): Int {
  
    var newELO = currentELO
    val squatToBWRatio = startingELO.squatMax / currentWeight
  
    println("sqr ratio:  + $squatToBWRatio")
  
    newELO += if (squatToBWRatio >= 1.3 && squatToBWRatio < SQUAT_RATIO) generateRandom(10)
    else if (squatToBWRatio >= 1.6 && squatToBWRatio < 1.7) generateRandom(30)
    else if (squatToBWRatio >= 1.7 && squatToBWRatio < 1.8) generateRandom(40)
    else if (squatToBWRatio >= 1.8 && squatToBWRatio < 1.9) generateRandom(50)
    else if (squatToBWRatio >= 2.5 && squatToBWRatio < 2.6) generateRandom(55)
    else generateRandom(100)
  
    return ageFactor(startingELO, newELO)
  }
  
  override fun addDeadLiftFactors(currentELO: Int,
                                  startingELO: StartingELO,
                                  currentWeight: Float): Int {
  
    var newELO = currentELO
    val deadLiftToBWRatio = startingELO.deadLiftMax / currentWeight
  
    println("dd ratio:  + $deadLiftToBWRatio")
  
    newELO += if (deadLiftToBWRatio >= 1.9 && deadLiftToBWRatio < DEADLIFT_RATIO) generateRandom(10)
    else if (deadLiftToBWRatio >= 2.1 && deadLiftToBWRatio < 2.2) generateRandom(30)
    else if (deadLiftToBWRatio >= 2.3 && deadLiftToBWRatio < 2.4) generateRandom(40)
    else if (deadLiftToBWRatio >= 2.4 && deadLiftToBWRatio < 2.5) generateRandom(50)
    else if (deadLiftToBWRatio >= 2.5 && deadLiftToBWRatio < 2.6) generateRandom(55)
    else generateRandom(100)
  
    return ageFactor(startingELO, newELO)
    
  }
  
}