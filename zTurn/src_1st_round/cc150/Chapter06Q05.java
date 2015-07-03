package cc150;

/*
 * There is a building of 100 floors. If an egg drops from the Nth floor or above, 
 * it will break. If it is dropped from any floor below, it will not break. You are 
 * given two eggs. Find N, which minimizing the number of drops for the worst case.
 * 
 * always the same counts no matter where the egg breaks
 * 
 * 100 = x + (x - 1) + (x -2) + .... + 2 + 1
 * 100 = x * (x + 1) / 2
 * 
 * x = 14
 */
public class Chapter06Q05 {

}
