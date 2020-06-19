package com.epam.day3.creatorTest;

import com.epam.day3.creater.BallCreator;
import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BallCreatorTest {

    private BallCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new BallCreator();
    }

    @Test
    public void createBallAssertObjectPresentsTest() {
        Ball actual = creator.createBall();
        assertNotNull(actual);
    }

    @Test
    public void createBallAssertVolumePresentsTest() {
        Ball actual = creator.createBall();
        assertNotNull(actual.getVolume());
    }

    @Test
    public void createBallAssertColorPresentsTest() {
        Ball actual = creator.createBall();
        assertNotNull(actual.getColor());
    }

    @Test
    public void createBallAssertWeightPresentsTest() {
        Ball actual = creator.createBall();
        assertNotNull(actual.getWeight());
    }

    @Test
    public void createBallAssertWeightBordersTest() {
        Ball actual = creator.createBall();
        assertTrue(actual.getWeight() > 0 && actual.getWeight() < 999.9);
    }

    @Test
    public void createBallAssertVolumeBordersTest() {
        Ball actual = creator.createBall();
        assertTrue(actual.getVolume() > 0 && actual.getVolume() < 9.9);
    }

    @Test
    public void createBallAssertColorBordersTest() {
        Ball actual = creator.createBall();
        assertTrue(actual.getColor().equals(Color.BLUE) || actual.getColor().equals(Color.RED)
                || actual.getColor().equals(Color.BLACK) || actual.getColor().equals(Color.YELLOW)
                || actual.getColor().equals(Color.WHITE));
    }

    @Test
    public void createBallsListAssertBallPresentsTest() {
        List<Ball> actual = creator.createBallsList();
        assertNotNull(actual);
    }

    @Test
    public void createBallsListAssertListSizeTest() {
        List<Ball> actual = creator.createBallsList();
        assertTrue(actual.size() < 10);
    }

    @Test(timeOut = 100)
    public void createBallsListAssertVolumeBordersTest() {
        List<Ball> actual = creator.createBallsList();
        for (int i = 0; i < actual.size(); i++) {
            assertFalse(actual.get(i).getVolume() < 0.16 && actual.get(i).getVolume() > 5.6);

        }
    }

}
