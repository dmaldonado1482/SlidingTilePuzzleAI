/**
 * See comments below first.  Then, return back up here.
 *
 * STEP 9: Save the output of your program (STEP 8) to a text file, and include that file when you submit your assignment.
 *
 * STEP 10: Answer this question in this comment:
 *     Question: Part of your step 8 should confirm the effect we saw in class that a more informed heuristic leads to fewer state expansions.
 *               Does it also have an effect on memory usage (i.e., number of generated states)?
 *
 *               When a heuristic is used, there are less states being expanded with even less states being expanded when using
 *               a more informed heuristic. In this case, UCS does not use a heuristic and the number of expanded and generated
 *               states is much greater compared to using A* with either of the two heuristics we used. When comparing misplaced
 *               tiles heuristic and Manhattan distance heuristic, the results show that there are much less expanded and generated
 *               states using Manhattan distance. Manhattan Distance is a better and more informed heuristic than misplaced tiles.
 *
 *
 * EXTRA CREDIT INSTRUCTIONS:
 * You do not need to do all of the extra credit parts.  You can: (a) do none of them and thus get no extra credit, (b) do EXTRA CREDIT STEPS 11 and 12,
 * (c) do EXTRA CREDIT STEPS 13 through 16, or (d) do EXTRA CREDIT STEPS 11 through 16.  Those are the only valid combinations of extra credit parts.
 *
 * EXTRA CREDIT STEP 11: Add code to the main method below to compute the average CPU time, and to output a 3rd table for the average CPU time.
 *                       Make sure your output in STEP 9 includes this additional table.
 * EXTRA CREDIT STEP 12: Answer this question in this comment:
 *     Question: More informed heuristics lead to fewer state expansions, but more informed heuristics typically require more time to compute,
 *               so may or may not be better to use.  Based on your timing results, is the added cost of computing Manhattan Distance worthwhile?
 *
 *               I believe that it is worthwhile to use the most informed heuristic you can because it is much easier to overwhelm
 *               memory usage compared to CPU time taking too long. On much larger searches, it is possible to run out of memory so using a good
 *               informed heuristic is beneficial.
 *
 * EVEN MORE EXTRA CREDIT STEP 13: Implement another heuristic function in the SlidingTilePuzzleSolver file, specifically this additional heuristic
 *    function should compute: a * h(s) where h(s) is the Manhattan Distance for state s, and where a >= 1.  The class that implements this heuristic
 *    function will need a constructor enabling passing a (you can't change the signature line of the h method).
 * EVEN MORE EXTRA CREDIT STEP 14: Add whatever code is necessary to your main method below to have an additional column for A*h3 to your tables
 *   (make sure you update the text file you submit for STEP 9).  You can decide on the value of a, but it should be relatively close to 1,
 *   such as 1.1, 1.2, etc.
 * EVEN MORE EXTRA CREDIT STEP 15: Desscribe in this comment any cost savings from using this heuristic relative to using Manhattan Distance.
 * EVEN MORE EXTRA CREDIT STEP 16: Also in this comment, indicate whether this heuristic is admissible.
 *
 */
public class SlidingTileComparison {


    public static void main(String[] args) {

        // STEP 8:  Implement whatever code is necessary to do the following.
        //   For each of the following optimal path lengths (2, 4, 6, 8, 10) generate 10 random 8-puzzles (see sample code in SomeSampleCode).
        //   At each of those lengths, average the number of states expanded by UniformCostSearch and average the number of states generated
        //   by Uniform Cost Search (if STEPS 3, 5, and 6 are correct, you can get these with the methods getNumExpandedStates and getNumGeneratedStates).
        //   Likewise, do the same for A* using number of misplaced tiles as the heuristic.
        //   And do the same for A* using Manhattan distance as the heuristic.
        //   NOTE: The puzzles you use with Uniform Cost Search should be the same as with A*.
        //
        //   Your output from this program should be in the form of two tables as follows (with the same or similar column headings).
        //   The tables can either be side by side like in the comment below, or one followed by the other.
        //
        //   Number of Expanded States     Number of Generated States
        //   L  UCS   A*h1   A*h2          L  UCS   A*h1   A*h2
        //   2                             2
        //   4                             4
        //   6                             6
        //   8                             8
        //   10                            10
        //
        //   The UCS column should have the average across the 10 puzzles at the relevant path length.
        //   The A*h1 likewise should have those averages for A* with number of misplaced tiles.
        //   The A*h2 likewise should have those averages for A* with manhattan distance.
        //
        //   After you run your program, you should find that the UCS number of expanded states is the highest, followed by
        //   A*h1, and A*h2 should have the lowest number of expanded states (assuming your STEPS 1 through 6 are correct)
        //   since number of misplaced tiles is more informed than no heuristic (UCS), and Manhattan distance is more informed
        //   than number of misplaced tiles.
        //
        //   REMINDER: An integer divided by an integer only gives you the whole number portion of the result, so be careful when
        //             computing the averages since number of expanded states and number of generated states are integers.
        //             If total is the sum of the number of expanded states across the 10 runs at a given length, and you do total/10
        //             you will get the wrong answer (if total is an int).

        SlidingTilePuzzleSolver solver = new SlidingTilePuzzleSolver();
        ManhattanDistance manhattan = new ManhattanDistance();
        NumMisplacedTiles misplaced = new NumMisplacedTiles();

        // UCS results
        double totalExpanded2 = 0;
        double totalGenerated2 = 0;
        double totalExpanded4 = 0;
        double totalGenerated4 = 0;
        double totalExpanded6 = 0;
        double totalGenerated6 = 0;
        double totalExpanded8 = 0;
        double totalGenerated8 = 0;
        double totalExpanded10 = 0;
        double totalGenerated10 = 0;

        // A* ManhattanDistance results
        double manExpanded2 = 0;
        double manGenerated2 = 0;
        double manExpanded4 = 0;
        double manGenerated4 = 0;
        double manExpanded6 = 0;
        double manGenerated6 = 0;
        double manExpanded8 = 0;
        double manGenerated8 = 0;
        double manExpanded10 = 0;
        double manGenerated10 = 0;

        // A* with misplaced tiles
        double misplacedExpanded2 = 0;
        double misplacedGenerated2 = 0;
        double misplacedExpanded4 = 0;
        double misplacedGenerated4 = 0;
        double misplacedExpanded6 = 0;
        double misplacedGenerated6 = 0;
        double misplacedExpanded8 = 0;
        double misplacedGenerated8 = 0;
        double misplacedExpanded10 = 0;
        double misplacedGenerated10 = 0;

        long cpuBefore = 0;
        long cpuAfter = 0;
        long cpuUCS2 = 0;
        long cpuUCS4 = 0;
        long cpuUCS6 = 0;
        long cpuUCS8 = 0;
        long cpuUCS10 = 0;

        long cpuMan2 = 0;
        long cpuMan4 = 0;
        long cpuMan6 = 0;
        long cpuMan8 = 0;
        long cpuMan10 = 0;

        long cpuMis2 = 0;
        long cpuMis4 = 0;
        long cpuMis6 = 0;
        long cpuMis8 = 0;
        long cpuMis10 = 0;



        for(int i=0; i < 10; i++)
        {
            SlidingTilePuzzle puzzle2 = new SlidingTilePuzzle(3, 3, 2);
            cpuBefore = System.nanoTime();
            solver.uniformCostSearch(puzzle2);
            totalExpanded2 += solver.getNumExpandedStates();
            totalGenerated2 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuUCS2 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle2, manhattan);
            manExpanded2 += solver.getNumExpandedStates();
            manGenerated2 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMan2 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle2, misplaced);
            misplacedExpanded2 += solver.getNumExpandedStates();
            misplacedGenerated2 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMis2 = cpuAfter - cpuBefore;



            SlidingTilePuzzle puzzle4 = new SlidingTilePuzzle(3, 3, 4);
            cpuBefore =  System.nanoTime();
            solver.uniformCostSearch(puzzle4);
            totalExpanded4 += solver.getNumExpandedStates();
            totalGenerated4 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuUCS4 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle4, manhattan);
            manExpanded4 += solver.getNumExpandedStates();
            manGenerated4 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMan4 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle4, misplaced);
            misplacedExpanded4 += solver.getNumExpandedStates();
            misplacedGenerated4 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMis4 = cpuAfter - cpuBefore;



            SlidingTilePuzzle puzzle6 = new SlidingTilePuzzle(3, 3, 6);
            cpuBefore =  System.nanoTime();
            solver.uniformCostSearch(puzzle6);
            totalExpanded6 += solver.getNumExpandedStates();
            totalGenerated6 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuUCS6 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle6, manhattan);
            manExpanded6 += solver.getNumExpandedStates();
            manGenerated6 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMan6 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle6, misplaced);
            misplacedExpanded6 += solver.getNumExpandedStates();
            misplacedGenerated6 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMis6 = cpuAfter - cpuBefore;



            SlidingTilePuzzle puzzle8 = new SlidingTilePuzzle(3, 3, 8);
            cpuBefore =  System.nanoTime();
            solver.uniformCostSearch(puzzle8);
            totalExpanded8 += solver.getNumExpandedStates();
            totalGenerated8 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuUCS8 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle8, manhattan);
            manExpanded8 += solver.getNumExpandedStates();
            manGenerated8 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMan8 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle8, misplaced);
            misplacedExpanded8 += solver.getNumExpandedStates();
            misplacedGenerated8 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMis8 = cpuAfter - cpuBefore;



            SlidingTilePuzzle puzzle10 = new SlidingTilePuzzle(3, 3, 10);
            cpuBefore =  System.nanoTime();
            solver.uniformCostSearch(puzzle10);
            totalExpanded10 += solver.getNumExpandedStates();
            totalGenerated10 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuUCS10 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle10, manhattan);
            manExpanded10 += solver.getNumExpandedStates();
            manGenerated10 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMan10 = cpuAfter - cpuBefore;

            cpuBefore = System.nanoTime();
            solver.AStarSearch(puzzle10, misplaced);
            misplacedExpanded10 += solver.getNumExpandedStates();
            misplacedGenerated10 += solver.getNumGeneratedStates();
            cpuAfter = System.nanoTime();
            cpuMis10 = cpuAfter - cpuBefore;
        }
        System.out.println("\n");

        // UCS results
        double averageExpanded2 = totalExpanded2 / 10;
        double averageGenerated2 = totalGenerated2 / 10;
        double averageExpanded4 = totalExpanded4 / 10;
        double averageGenerated4 = totalGenerated4 / 10;
        double averageExpanded6 = totalExpanded6 / 10;
        double averageGenerated6 = totalGenerated6 / 10;
        double averageExpanded8 = totalExpanded8 / 10;
        double averageGenerated8 = totalGenerated8 / 10;
        double averageExpanded10 = totalExpanded10 / 10;
        double averageGenerated10 = totalGenerated10 / 10;

        // A* Manhattan Distance Results
        double avgManExpanded2 = manExpanded2 / 10;
        double avgManGenerated2 = manGenerated2 / 10;
        double avgManExpanded4 = manExpanded4 / 10;
        double avgManGenerated4 = manGenerated4 / 10;
        double avgManExpanded6 = manExpanded6 / 10;
        double avgManGenerated6 = manGenerated6 / 10;
        double avgManExpanded8 = manExpanded8 / 10;
        double avgManGenerated8 = manGenerated8 / 10;
        double avgManExpanded10 = manExpanded10 / 10;
        double avgManGenerated10 = manGenerated10 / 10;

        // A* with misplaced tiles results
        double avgMisExpanded2 = misplacedExpanded2 / 10;
        double avgMisGenerated2 = misplacedGenerated2 / 10;
        double avgMisExpanded4 = misplacedExpanded4 / 10;
        double avgMisGenerated4 = misplacedGenerated4 / 10;
        double avgMisExpanded6 = misplacedExpanded6 / 10;
        double avgMisGenerated6 = misplacedGenerated6 / 10;
        double avgMisExpanded8 = misplacedExpanded8 / 10;
        double avgMisGenerated8 = misplacedGenerated8 / 10;
        double avgMisExpanded10 = misplacedExpanded10 / 10;
        double avgMisGenerated10 = misplacedGenerated10 / 10;

        long finalCpuUCS2 = cpuUCS2 / 10;
        long finalCpuUCS4 = cpuUCS4 / 10;
        long finalCpuUCS6 = cpuUCS6 / 10;
        long finalCpuUCS8 = cpuUCS8 / 10;
        long finalCpuUCS10 = cpuUCS10 / 10;

        long finalMan2 = cpuMan2 / 10;
        long finalMan4 = cpuMan4 / 10;
        long finalMan6 = cpuMan6 / 10;
        long finalMan8 = cpuMan8 / 10;
        long finalMan10 = cpuMan10 / 10;

        long finalMis2 = cpuMis2 / 10;
        long finalMis4 = cpuMis4 / 10;
        long finalMis6 = cpuMis6 / 10;
        long finalMis8 = cpuMis8 / 10;
        long finalMis10 = cpuMis10 / 10;


        System.out.println("Number of Expanded States");
        System.out.println("L\tUCS\tA*h1\tA*h2");
        System.out.println("2\t" + averageExpanded2 + "\t" + avgMisExpanded2 + "\t" + avgManExpanded2);
        System.out.println("4\t" + averageExpanded4 + "\t" + avgMisExpanded4 + "\t" + avgManExpanded4);
        System.out.println("6\t" + averageExpanded6 + "\t" + avgMisExpanded6 + "\t" + avgManExpanded6);
        System.out.println("8\t" + averageExpanded8 + "\t" + avgMisExpanded8 + "\t" + avgManExpanded8);
        System.out.println("10\t" + averageExpanded10 + "\t" + avgMisExpanded10 + "\t" + avgManExpanded10);

        System.out.println("\n");

        System.out.println("Numer of Generated States");
        System.out.println("L\tUCS\tA*h1\tA*h2");
        System.out.println("2\t" + averageGenerated2 + "\t" + avgMisGenerated2 + "\t" + avgManGenerated2);
        System.out.println("4\t" + averageGenerated4 + "\t" + avgMisGenerated4 + "\t" + avgManGenerated4);
        System.out.println("6\t" + averageGenerated6 + "\t" + avgMisGenerated6 + "\t" + avgManGenerated6);
        System.out.println("8\t" + averageGenerated8 + "\t" + avgMisGenerated8 + "\t" + avgManGenerated8);
        System.out.println("10\t" + averageGenerated10 + "\t" + avgMisGenerated10 + "\t" + avgManGenerated10);

        System.out.println("\n");

        System.out.println("CPU Time (Nanoseconds)");
        System.out.println("L\tUCS\tA*h1\tA*h2");
        System.out.println("2\t" + finalCpuUCS2 + "\t" + finalMis2 + "\t" + finalMan2);
        System.out.println("4\t" + finalCpuUCS4 + "\t" + finalMis4 + "\t" + finalMan4);
        System.out.println("6\t" + finalCpuUCS6 + "\t" + finalMis6 + "\t" + finalMan6);
        System.out.println("8\t" + finalCpuUCS8 + "\t" + finalMis8 + "\t" + finalMan8);
        System.out.println("10\t" + finalCpuUCS10 + "\t" + finalMis10 + "\t" + finalMan10);



    }
}





