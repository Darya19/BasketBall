package com.epam.day3.validatorTest;

import com.epam.day3.validator.BallValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BallValidatorTest {

    BallValidator validator;
    @BeforeClass
    public void setUp(){
       validator = new BallValidator();
    }

    @Test
    public void validateBallWeightNegativeTest(){
        assertFalse(validator.validateBallWeight(501.142));
    }

    @Test
    public void validateBallWeightPositiveTest(){
        assertTrue(validator.validateBallWeight(423.012));
    }

    @Test
    public void validateBallVolumeNegativeTest(){
        assertFalse(validator.validateBallVolume(0.15));
    }

    @Test
    public void validateBallVolumePositiveTest(){
        assertTrue(validator.validateBallVolume(0.16));
    }
}
