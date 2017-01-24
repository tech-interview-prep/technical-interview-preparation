Five Steps to a Technical Question
A technical interview question can be solved utilizing a five step approach:
1. Ask your interviewer questions to resolve ambiguity.
2. Design an Algorithm.
3. Write pseudocode first, but make sure to tell your interviewer that you'll eventually write "real"code.
4. Write your code at a moderate pace.
5. Test your code and carefully fix any mistakes.
We will go through each of these steps in more detail below.
Step 1: AskQuestions
Technical problems are more ambiguous than they might appear, so make sure to ask questions to resolve anything that might be unclear. You may eventually wind up with a very different—or much easier—problem than you had initially thought. In fact, many interviewers (especially at Microsoft) will specifically test to see if you ask good ques- tions.
Good questions might be ones like: What are the data types? How much data is there? What assumptions do you need to solve the problem? Who is the user?
Example: "Design an algorithm to sort a list."
• • •
Question: What sort of list? An array? A linked list?
Answer: An array.
Question: What does the array hold? Numbers?Characters? Strings? Answer: Numbers.
Question: And are the numbers integers?
Answer: Yes.
• Question: Where did the numbers come from? Are they IDs? Values of something?
Answer: They are the ages of customers.
• Question: And how many customers are there?
Answer: About a million.
We now have a pretty different problem: sort an array containing a million integers between Oand 130 (a reasonable maximum age). How do we solve this? Just create an array with 130 elements and count the number of ages at each value.
Step 2: Design an Algorithm
Designing an algorithm can be tough, but our Five Approaches to Algorithms (see next section) can help you out. While you're designing your algorithm, don't forget to ask yourself the following:
• • •
• •
What are its space and time complexity?
What happens if there is a lot of data?
Does your design cause other issues? For example, if you're creating a modified version of a binary search tree, did your design impact the time for insert, find, or delete?
If there are other issues or limitations, did you make the right trade-offs? For which scenarios might the trade-off be less optimal?
If they gave you specific data (e.g., mentioned that the data is ages, or in sorted order), have you leveraged that information? Usually there's a reason that an inter- viewer gave you specific information.
It's perfectly acceptable, and even recommended, to first mention the brute force solu- tion. You can then continue to optimize from there. You can assume that you're always expected to create the most optimal solution possible, but that doesn't mean that the first solution you give must be perfect.
Step 3: Pseudocode
Writing pseudocode first can help you outline your thoughts clearly and reduce the number of mistakes you commit. But, make sure to tell your interviewer that you're writing pseudocode first and that you'll follow it up with "real" code. Many candidates will write pseudocode in order to "escape" writing real code, and you certainly don't want to be confused with those candidates.
Step 4: Code
You don't need to rush through your code; in fact, this will most likely hurt you. Just go at a nice, slow, methodical pace. Also, remember this advice:
•
•
Use Data Structures Generously: Where relevant, use a good data structure or define your own. Forexample, if you're asked a problem involving finding the minimum age for a group of people, consider defining a data structure to represent a Person. This shows your interviewer that you care about good object-oriented design.
Don't Crowd Your Coding: This is a minor thing, but it can really help. When you're writing code on a whiteboard, start in the upper left hand corner rather than in the middle. This will give you plenty of space to write your answer.
Step 5: Test
Yes, you need to test your code! Consider testing for:
• Extremecases: 0, negative, null, maximums, minimums.
• User error:What happens if the user passes in null or a negative value?
• General cases: Test the normal case.
If the algorithm is complicated or highly numerical (bit shifting, arithmetic, etc.), consider testing while you're writing the code rather than just at the end.
When you find mistakes (which you will), carefully think through why the bug is occur- ring before fixing the mistake. You do not want to be seen as a "random fixer" candi- date: one who, for example, finds that their function returns true instead of false for a particular value, and so just flips the return value and tests to see if the function works. This might fix the issue for that particular case, but it inevitably creates several new issues.
When you notice problems in your code, really think deeply about why your code failed before fixing the mistake.You'll create beautiful, clean code much, much faster.
