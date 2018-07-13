package com.ajayrockstarindevops.interviewQuestionsTools


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ajayrockstarindevops.adapter.GitAdapter.GitInterviewAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.GitModel.GitInterviewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GitInterviewQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */

//https://career.guru99.com/top-40-interview-questions-on-git/
//https://tekslate.com/git-interview-questions
//https://www.onlineinterviewquestions.com/git-interview-questions/#.W0R3PtUzbIU
//https://svrtechnologies.com/devops-interview-questions/top-50-devops-git-interview-questions-and-answers-pdf
//https://www.janbasktraining.com/blog/git-interview-questions/
//https://www.git-tower.com/learn/git/faq/difference-between-git-fetch-git-pull
//https://svrtechnologies.com/devops-interview-questions/top-30-devops-git-interview-questions-and-answers-pdf
//https://intellipaat.com/interview-question/devops-interview-questions/  devops interview questions
//https://career.guru99.com/top-11-devops-interview-questions/
//https://linoxide.com/linux-how-to/devops-interview-questions-answers/  devops inq
//https://learning.naukri.com/articles/devops-interview-questions-answers/ devops iq
//https://www.wisdomjobs.com/e-university/aws-devops-interview-questions.html  aws in devops iq
//https://pantheon.io/docs/git-faq/
//https://genome.sph.umich.edu/w/index.php?title=Git_FAQs&mobileaction=toggle_view_mobile

class GitInterviewQuestionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_git_interview_questions, container, false)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<GitInterviewModel>()
        users.add(GitInterviewModel("1. What is GIT?", "GIT is a distributed version control system and source code management (SCM) system with an emphasis to handle small and large projects with speed and efficiency.\n" +
                "GIT is recommended to be used because of its following advantages:\n" +
                "\n" +
                "* Any project can use GIT without any restrictions.\n" +
                "* It is collaboration-friendly.\n" +
                "* It has superior disk utilization and network performance.\n" +
                "* There can be only one.GIT directory per repository.\n" +
                "* High availability, Data redundancy, and replication."))
        users.add(GitInterviewModel("2.  What is a repository in GIT?","A repository contains a directory named .git, where git keeps all of its metadata for the repository. The content of the .git directory are private to git."))
        users.add(GitInterviewModel("3. What is the command you can use to write a commit message?","The command that is used to write a commit message is “git commit –a”.  The –a on the command line instructs git to commit the new content of all tracked files that have been modified. You can use “git add<file>” before git commit –a if new files need to be committed for the first time."))
        users.add(GitInterviewModel("4. What are GIT stash and GIT stash drop?","GIT stash:\n" +
                "\n" +
                "It takes the current state of working directory and index and pushes into the stack for later and returns to you the clean working directory.GIT stash will help you in the instances where you are working on a project and you want to switch the branches to work on something else.\n" +
                "\n" +
                "GIT stash drop:\n" +
                "\n" +
                "When you are done and want to eliminate the stashed item from the list, then running the GIT “stash drop” command will remove the last added stash item by default and can also remove the specific item if any argument is included or mentioned."))
        users.add(GitInterviewModel("5. What is a GIT commit and what does the commit object contain?","A GIT commit is a command that is executed in the course of a project to records progress.\n" +
                "\n" +
                "The commit object contains the following components\n" +
                "\n" +
                "* A set of files that represents the state of the file at any instance of time.\n" +
                "* Reference to the parent commit\n" +
                "* An SHAI name, a 40-character string that can uniquely identify the commit object."))
        users.add(GitInterviewModel("6. What is the purpose of branching and how many branching strategies can you apply?","The branching in GIT is done to allow the user to create their own branch and toggle between those branches. It will allow the user to go to the previous work keeping the current work intact.\n" +
                "\n" +
                "Branching Strategies:\n" +
                "\n" +
                "* Feature Branching – It keeps all the changes of a specific feature in a branch and when the feature is completely tested and validated it is merged into the master.\n" +
                "* Task branching – It is included in its own branch with the task key included in the branch name.\n" +
                "* Release Branching – When the developed branch acquires enough features for a release, the user can clone that branch to form a releasing branch."))
        users.add(GitInterviewModel("7. What is the difference between GIT and SVN?","The difference between GIT and SVN is\n" +
                "\n" +
                "a)      Git is less preferred for handling extremely large files or frequently changing binary files while SVN can handle multiple projects stored in the same repository.\n" +
                "\n" +
                "b)      GIT does not support ‘commits’ across multiple branches or tags.  Subversion allows the creation of folders at any location in the repository layout.\n" +
                "\n" +
                "c)        Gits are unchangeable, while Subversion allows committers to treat a tag as a branch and to create multiple revisions under a tag root."))
        users.add(GitInterviewModel("8.  What are the advantages of using GIT?","a) Data redundancy and replication\n" +
                "b) High availability \n" +
                "c) Only one.git directory per repository\n" +
                "d) Superior disk utilization and network performance\n" +
                "e) Collaboration friendly\n" +
                "f) Any sort of projects can use GIT"))
        users.add(GitInterviewModel("9. What language is used in GIT?","GIT is fast, and ‘C’ language makes this possible by reducing the overhead of runtimes associated with higher languages."))
        users.add(GitInterviewModel("10. What is the function of ‘GIT PUSH’ in GIT?","‘GIT PUSH’ updates remote refs along with associated objects."))
        users.add(GitInterviewModel("11. What commands will you use to bring a new feature to the main branch?","By running “GIT merge” or “GIT pull” commands, the user can bring a new feature to the main branch."))
        users.add(GitInterviewModel("12. Distinguish between GIT fetch and GIT pull?","GIT fetch – It downloads only the new data from the remote repository and does not integrate any of the downloaded data into your working files. Providing a view of the data is all it does.\n" +
                "\n" +
                "GIT pull – It downloads as well as merges the data from the remote repository into the local working files. This may also lead to merging conflicts if the user’s local changes are not yet committed. Using the “GIT stash” command hides the local changes."))
        users.add(GitInterviewModel("13. What is subGIT and why is it used?","SubGIT – It is a tool for smooth and stress-free subversion to GIT migration and also a solution for a company-wide subversion to GIT migration that is:\n" +
                "\n" +
                "* It allows to make use of all GIT and subversion features.\n" +
                "* It provides genuine stress-free migration experience.\n" +
                "* It doesn’t require any change in the infrastructure that is already placed.\n" +
                "* It is considered to be much better than GIT-SVN\n"))
        users.add(GitInterviewModel("14. What are the disadvantages of GIT ?","GIT has not very many weaknesses. These are the situations when GIT is hard to utilize. Some of these are:\n" +
                "\n" +
                "Binary Files: If we have a considerable measure double records (non-content) in our venture, at that point GIT turns out to be moderate. E.g. Tasks with a lot of pictures or Word records.\n" +
                "\n" +
                "Steep Learning Curve: It sets aside some time for a newcomer to learn GIT. A portion of the GIT summons is non-instinctive to a fresher.\n" +
                "\n" +
                "Slow remote speed: Sometimes the utilization of remote stores in ease back because of system dormancy. Still, GIT is superior to different VCS in speed."))
        users.add(GitInterviewModel("15. Why GIT better than Subversion?","GIT is an open source version control system; it will allow you to run ‘versions’ of a project, which show the changes that were made to the code overtime also it allows you keep the backtrack if necessary and undo those changes.  Multiple developers can checkout, and upload changes and each change can then be attributed to a specific developer."))
        users.add(GitInterviewModel("16. What is “Staging Area” or “Index” in GIT?","Before completing the commits, it can be formatted and reviewed in an intermediate area known as ‘Staging Area’ or ‘Index’."))
        users.add(GitInterviewModel("17. What is GIT stash?","GIT stash takes the current state of the working directory and index and puts in on the stack for later and gives you back a clean working directory.  So in case if you are in the middle of something and need to jump over to the other job, and at the same time you don’t want to lose your current edits then you can use GIT stash."))
        users.add(GitInterviewModel("18. What is GIT stash drop?","When you are done with the stashed item or want to remove it from the list, run the git ‘stash drop’ command.  It will remove the last added stash item by default, and it can also remove a specific item if you include as an argument."))
        users.add(GitInterviewModel("19. How will you know in GIT if a branch has been already merged into master?","Git branch—merged lists the branches that have been merged into the current branch\n" +
                "\n" +
                "Git branch—-no merged lists the branches that have not been merged"))
        users.add(GitInterviewModel("20. What is the function of ‘git config’?","The ‘git config’ command is a convenient way to set configuration options for your Git installation.  Behaviour of a repository, user info, preferences etc. can be defined through this command."))
        users.add(GitInterviewModel("21. What is the function of git clone?","The git clone command creates a copy of an existing Git repository.  To get the copy of a central repository, ‘cloning’  is the most common way used by programmers."))
        users.add(GitInterviewModel("22. What is ‘head’ in git and how many heads can be created in a repository?","A ‘head’ is simply a reference to a commit object. In every repository, there is a default head referred as “Master”.  A repository can contain any number of heads."))
        users.add(GitInterviewModel("23. What is the purpose of branching in GIT?","The purpose of branching in GIT is that you can create your own branch and jump between those branches. It will allow you to go to your previous work keeping your recent work intact."))
        users.add(GitInterviewModel("24. What is the common branching pattern in GIT?","The common way of creating branch in GIT is to maintain one as “Main“\n" +
                "\n" +
                "branch and create another branch to implement new features. This pattern is particularly useful when there are multiple developers working on a single project."))
        users.add(GitInterviewModel("25. How can you bring a new feature in the main branch?","To bring a new feature in the main branch, you can use a command “git merge” or “git pull command”."))
        users.add(GitInterviewModel("26. What is a ‘conflict’ in git?","A ‘conflict’ arises when the commit that has to be merged has some change in one place, and the current commit also has a change at the same place. Git will not be able to predict which change should take precedence."))
        users.add(GitInterviewModel("27. How can conflict in git resolved?","To resolve the conflict in git, edit the files to fix the conflicting changes and then add the resolved files by running “git add” after that to commit the repaired merge,  run “git commit”.  Git remembers that you are in the middle of a merger, so it sets the parents of the commit correctly."))
        users.add(GitInterviewModel("28. To delete a branch what is the command that is used?","Once your development branch is merged into the main branch, you don’t need\n" +
                "\n" +
                "development branch.  To delete a branch use, the command “git branch –d [head]”."))
        users.add(GitInterviewModel("29. What is another option for merging in git?","“Rebasing” is an alternative to merging in git."))
        users.add(GitInterviewModel("30. What is the syntax for “Rebasing” in Git?","The syntax used for rebase is “git rebase [new-commit] “"))
        users.add(GitInterviewModel("31. What is the difference between ‘git remote’ and ‘git clone’?","‘git remote add’  just creates an entry in your git config that specifies a name for a particular URL.  While, ‘git clone’ creates a new git repository by copying and existing one located at the URI."))
        users.add(GitInterviewModel("32. Mention some of the best graphical GIT client for LINUX?","Some of the best GIT client for LINUX is\n" +
                "\n" +
                "a)Git Cola\n" +
                "b)Git-g\n" +
                "c)Smart git\n" +
                "d)Giggle\n" +
                "e)Git GUI\n" +
                "f)qGit"))
        users.add(GitInterviewModel("33. What is the function of ‘git diff ’ in git?","‘git diff ’ shows the changes between commits, commit and working tree etc."))
        users.add(GitInterviewModel("34. What is ‘git status’ is used for?","As ‘Git Status’ shows you the difference between the working directory and the index, it is helpful in understanding a git more comprehensively."))
        users.add(GitInterviewModel("35.  What is the difference between the ‘git diff ’and ‘git status’?","‘git diff’ is similar to ‘git status’, but it shows the differences between various commits and also between the working directory and index."))
        users.add(GitInterviewModel("36. What is the function of ‘git checkout’ in git?","A ‘git checkout’ command is used to update directories or specific files in your working tree with those from another branch without merging it in the whole branch."))
        users.add(GitInterviewModel("37.  What is the function of ‘git rm’?","To remove the file from the staging area and also off your disk ‘git rm’ is used."))
        users.add(GitInterviewModel("38.  What is the function of ‘git stash apply’?","When you want to continue working where you have left your work, ‘git stash apply’ command is used to bring back the saved changes onto the working directory."))
        users.add(GitInterviewModel("39. What is the use of ‘git log’?","To find specific commits in your project history- by author, date, content or history ‘git log’ is used."))
        users.add(GitInterviewModel("40. What is ‘git add’ is used for?","git add’ adds file changes in your existing directory to your index."))
        users.add(GitInterviewModel("41. What is the function of ‘git reset’?","The function of ‘Git Reset’ is to reset your index as well as the working directory to the state of your last commit."))
        users.add(GitInterviewModel("42.  What is git Is-tree?","‘git Is-tree’ represents a tree object including the mode and the name of each item and the SHA-1 value of the blob or the tree."))
        users.add(GitInterviewModel("43. How git instaweb is used?","Git Instaweb’ automatically directs a web browser and runs webserver with an interface into your local repository."))
        users.add(GitInterviewModel("44. What does ‘hooks’ consist of in git?","This directory consists of Shell scripts which are activated after running the corresponding Git commands.  For example, git will try to execute the post-commit script after you run a commit."))
        users.add(GitInterviewModel("45. Explain what is commit message?","Commit message is a feature of git which appears when you commit a change. Git provides you a text editor where you can enter the modifications made in commits."))
        users.add(GitInterviewModel("46. How can you fix a broken commit?","To fix any broken commit, you will use the command “git commit—amend”. By running this command, you can fix the broken commit message in the editor."))
        users.add(GitInterviewModel("47.  Why is it advisable to create an additional commit rather than amending an existing commit?","There are couple of reason\n" +
                "\n" +
                "a)      The amend operation will destroy the state that was previously saved in a commit.  If it’s just the commit message being changed then that’s not an issue.  But if the contents are being amended then chances of eliminating something important remains more.\n" +
                "\n" +
                "b)      Abusing “git commit- amend” can cause a small commit to grow and acquire unrelated changes."))
        users.add(GitInterviewModel("48. What is ‘bare repository’ in GIT?","To co-ordinate with the distributed development and developers team, especially when you are working on a project from multiple computers ‘Bare Repository’ is used. A bare repository comprises of a version history of your code."))
        users.add(GitInterviewModel("49. Name a few Git repository hosting services","\n" +
                "\n" +
                "* Pikacode\n" +
                "* Visual Studio Online\n" +
                "* GitHub\n" +
                "* GitEnterprise\n" +
                "* SourceForge.net"))
        users.add(GitInterviewModel("50. What is the main difference between Git and SVN","The major differentiating point between Git and an SVN is that Git is a distributed version control system (DVCS), while SVN is only a centralized version control system (CVCS)."))
        users.add(GitInterviewModel("51. What do you mean by Git fork?","A Git fork is nothing but a copy of a Git repository. In a Git ecosystem forking down a Repository enables you with liberal experimentation with different changes with little or no Effects on your original project."))
        users.add(GitInterviewModel("52.  What do you understand by the term cherry-pick in Git?","Cherry picking term in Git refers to the point of choice of a commit arising from one particular branch and then applying it to some other branch. This procedure is in disparity with the usual ways like merge and rebates which in general applies various different commits to another Git branch."))
        users.add(GitInterviewModel("53.  What is Git rebase?","Git rebase is a command that you give when you wish to merge some of the other Git branches into the branch wherein you are at present working, and shift all of the neighborhood commits that are in front of the rebased branch to the apex of the Git record on that branch."))
        users.add(GitInterviewModel("54.  What is the syntax for “Rebasing” in Git ?","The syntax used for rebase is “git rebase [new-commit]” "))
        //creating our adapter
        val adapter = GitInterviewAdapter(users)
        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
        return view

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GitInterviewQuestionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GitInterviewQuestionsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
