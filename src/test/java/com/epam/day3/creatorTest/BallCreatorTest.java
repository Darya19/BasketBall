package com.epam.day3.creatorTest;

import com.epam.day3.creator.BallCreator;
import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class BallCreatorTest {

    private BallCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new BallCreator();
    }

    @Test
    public void createBallsListAssertListPresentsTest() {
        List<Ball> actual = creator.createBallsList();
        assertNotNull(actual);
    }

    @Test
    public void createBallsListAssertLastBallPresentsTest() {
        List<Ball> actual = creator.createBallsList();
        assertNotNull(actual.get(actual.size() - 1));
    }

    @Test
    public void createBallsListAssertFirstBallPresentsTest() {
        List<Ball> actual = creator.createBallsList();
        assertNotNull(actual.get(actual.size() - 1));
    }

    @Test
    public void createBallsListAssertListSizeTest() {
        List<Ball> actual = creator.createBallsList();
        assertTrue(actual.size() < 5);
    }

    @Test(timeOut = 10)
    public void createBallsListAssertVolumeBordersTest() {
        List<Ball> actual = creator.createBallsList();
        assertTrue(actual.get(0).getVolume() >= 0.16 && actual.get(0).getVolume() <= 5.6);
    }

    @Test(timeOut = 10)
    public void createBallsListAssertWeightBordersTest() {
        List<Ball> actual = creator.createBallsList();
        assertTrue(actual.get(1).getWeight() <= 500 && actual.get(1).getWeight() >= 2.7);
    }

    @Test
    public void createBallAssertColorBordersTest() {
        List<Ball> actual = creator.createBallsList();
        assertTrue(actual.get(3).getColor().equals(Color.BLUE) || actual.get(3).getColor().equals(Color.RED)
                || actual.get(3).getColor().equals(Color.BLACK) || actual.get(3).getColor().equals(Color.YELLOW)
                || actual.get(3).getColor().equals(Color.WHITE));
    }
}
