package com.ajayrockstarindevops.commandsTools


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

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.adapter.GitAdapter.GitCommandsAdapter
import com.ajayrockstarindevops.model.GitModel.GitCommandsModel

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GitHubCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GitHubCommandsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mAdView : AdView
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
        val view = inflater.inflate(R.layout.fragment_git_hub_commands, container, false)
        //initalize ads
        MobileAds.initialize(activity, resources.getString(R.string.addmob_app_id))
        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<GitCommandsModel>()
        //adding some dummy data to the list
        users.add(GitCommandsModel("git --version ", "Check your version of Git"))
        users.add(GitCommandsModel("git config --global user.name \"Ajay Goud\"\n" +
                "git config --global user.email ajay@example.com", "Configure the author name and email address to be used with your commits.Note that Git strips some characters (for example trailing periods) from user.name."))
        users.add(GitCommandsModel("git init", "Initialize a local Git repository"))
        users.add(GitCommandsModel("git clone ssh://git@github.com/[username]/[repository-name].git", "Create a local copy of a remote repository"))
        users.add(GitCommandsModel("git status", "Check status"))
        users.add(GitCommandsModel("git add [file-name.txt]", "Add a file to the staging area"))
        users.add(GitCommandsModel("git add -A", "Add all new and changed files to the staging area"))
        users.add(GitCommandsModel("git commit -m \"[commit message]\"", "Commit changes"))
        users.add(GitCommandsModel("git rm -r [file-name.txt]", "Remove a file (or folder)"))
        users.add(GitCommandsModel("git branch", "List branches (the asterisk denotes the current branch)"))
        users.add(GitCommandsModel("git branch -a", "List all branches (local and remote)"))
        users.add(GitCommandsModel("git branch [branch name]", "Create a new branch"))
        users.add(GitCommandsModel("git branch -d [branch name]", "Delete a branch"))
        users.add(GitCommandsModel("git push origin --delete [branchName]", "Delete a remote branch"))
        users.add(GitCommandsModel("git checkout -b [branch name]", "Create a new branch and switch to it"))
        users.add(GitCommandsModel("git checkout -b [branch name] origin/[branch name]\t", "Clone a remote branch and switch to it"))
        users.add(GitCommandsModel("git checkout [branch name]", "Switch to a branch"))
        users.add(GitCommandsModel("git checkout -", "Switch to the branch last checked out"))
        users.add(GitCommandsModel("git checkout -- [file-name.txt]", "Discard changes to a file"))
        users.add(GitCommandsModel("git merge [branch name]", "Merge a branch into the active branch"))
        users.add(GitCommandsModel("git merge [source branch] [target branch]", "Merge a branch into a target branch"))
        users.add(GitCommandsModel("git stash", "Stash changes in a dirty working directory"))
        users.add(GitCommandsModel("git stash clear", "Remove all stashed entries"))
        users.add(GitCommandsModel("git push origin [branch name]", "Push a branch to your remote repository"))
        users.add(GitCommandsModel("git push -u origin [branch name]", "Push changes to remote repository (and remember the branch)"))
        users.add(GitCommandsModel("git push", "Push changes to remote repository (remembered branch)"))
        users.add(GitCommandsModel("git push origin --delete [branch name]", "Delete a remote branch"))
        users.add(GitCommandsModel("git pull", "Update local repository to the newest commit"))
        users.add(GitCommandsModel("git pull origin [branch name]", "Pull changes from remote repository"))
        users.add(GitCommandsModel("git remote add origin ssh://git@github.com/[username]/[repository-name].git", "Add a remote repository"))
        users.add(GitCommandsModel("git remote set-url origin ssh://git@github.com/[username]/[repository-name].git", "Set a repository's origin branch to SSH"))
        users.add(GitCommandsModel("git log", "View changes"))
        users.add(GitCommandsModel("git log --summary", "View changes (detailed)"))
        users.add(GitCommandsModel("git diff [source branch] [target branch}", "Preview changes before merging"))
        users.add(GitCommandsModel("git remote -v", "List all currently configured remote repositories:"))
        users.add(GitCommandsModel("git push --all origin", "Push all branches to your remote repository:"))
        users.add(GitCommandsModel("git diff\n" +
                "git diff --base <filename>\n" +
                "\n" +
                "git diff <sourcebranch> <targetbranch>", "View all the merge conflicts:\n" +
                "View the conflicts against the base file:\n" +
                "\n" +
                "Preview changes, before merging:"))
        users.add(GitCommandsModel("git tag 1.0.0 <commitID>", "You can use tagging to mark a significant changeset, such as a release:"))
        users.add(GitCommandsModel("git push --tags origin", "Push all tags to remote repository:"))
        users.add(GitCommandsModel("git fetch origin\n" +
                "\n" +
                "git reset --hard origin/master", "Instead, to drop all your local changes and commits, fetch the latest history from the server and point your local master branch at it, do this:"))
        users.add(GitCommandsModel("git grep \"foo()\"", "Search the working directory for foo():"))
        users.add(GitCommandsModel("git gc", "Garbage collector for your repository. Optimizes your repository. Should be run occasionally. "))
        users.add(GitCommandsModel("git fsck", "Does an integrity check of the Git file system, identifying corrupted objects. "))
        users.add(GitCommandsModel("git prune", "Removes objects that are no longer pointed to by any object in any reachable branch"))
        users.add(GitCommandsModel("git reset --hard HEAD", "Resets your index and working directory to the state of your last commit."))
        users.add(GitCommandsModel("git merge newbranchversion", "Merges one or more branches into your current branch and automatically creates a new commit if there are no conflicts."))
        users.add(GitCommandsModel("git config --global --list", "To view the information that you entered, along with other global options"))
        users.add(GitCommandsModel("git checkout master\n" +
                "git merge NAME-OF-BRANCH", "Merge master branch with created branch"))
        users.add(GitCommandsModel("git checkout NAME-OF-BRANCH\n" +
                "git merge master", "Merge created branch with master branch"))
        users.add(GitCommandsModel("git reset HEAD~1", "Undo most recent commit"))
        users.add(GitCommandsModel("git checkout .", "To delete all local changes in the repository that have not been added to the staging area, and leave unstaged files/folders"))
        users.add(GitCommandsModel("git clean -f", "Delete all untracked changes in the Git repository"))
        users.add(GitCommandsModel("git reset .", "To undo the most recent add, but not committed, files/folders:"))
        users.add(GitCommandsModel("git diff --cached", "See staged, non-commited changes"))
        users.add(GitCommandsModel("git diff --cached origin/master", "See diff before push"))
        users.add(GitCommandsModel("git show COMMIT_ID", "See details (log message, text diff) of a commit"))
        users.add(GitCommandsModel("git revert dd61ab21\n" +
                "git push origin master", "Revert one commit, push it"))
        users.add(GitCommandsModel("# reset the index to the desired tree\n" +
                "git reset 56e05fced\n" +
                "\n" +
                "# move the branch pointer back to the previous HEAD\n" +
                "git reset --soft HEAD@{1}\n" +
                "\n" +
                "git commit -m \"Revert to 56e05fced\"\n" +
                "\n" +
                "# Update working copy to reflect the new commit\n" +
                "git reset --hard", "Revert to the moment before one commit"))
        users.add(GitCommandsModel("git reset --soft HEAD~1", "Undo last commit, preserving local changes"))
        users.add(GitCommandsModel("git reset --hard HEAD~1", "Undo last commit, without preserving local changes"))
        users.add(GitCommandsModel("git reset origin/master", "Undo non-pushed commits"))
        users.add(GitCommandsModel("git fetch origin\n" +
                "git reset --hard origin/master", "Reset to remote state"))
        users.add(GitCommandsModel("git diff > patch-issue-1.patch", "Make some changes, create a patch"))
        users.add(GitCommandsModel("git add newfile\n" +
                "git diff --staged > patch-issue-2.patch", "Add a file and create a patch"))
        users.add(GitCommandsModel("git add newfile\n" +
                "git diff HEAD > patch-issue-2.patch", "Add a file, make some changes, and create a patch"))
        users.add(GitCommandsModel("git format-patch COMMIT_ID", "Make a patch for a commit"))
        users.add(GitCommandsModel("git format-patch HEAD~2", "Make patches for the last two commits"))
        users.add(GitCommandsModel("git format-patch origin/master", "Make patches for all non-pushed commits"))
        users.add(GitCommandsModel("git format-patch --binary --full-index origin/master", "Create patches that contain binary content"))
        users.add(GitCommandsModel("git apply -v patch-name.patch", "Apply a patch"))
        users.add(GitCommandsModel("git am patch1.patch", "Apply a patch created using format-patch"))
        users.add(GitCommandsModel("git add --patch file.txt\n" +
                "(press 'y' for the chunks to add)\n" +
                "git commit -m 'first part of the file'\n" +
                "(repeat if desired)", "Break up multiple changes into separate commits (or commit only part of a changed file)"))
        users.add(GitCommandsModel("history | grep git\n" +
                "or\n" +
                "\n" +
                "grep '^git'  /root/.bash_history", "See previous git commands executed"))
        users.add(GitCommandsModel("screen\n" +
                "for((i=1;i<=10000;i+=1)); do sleep 30 && git pull; done\n" +
                "Use Ctrl+a Ctrl+d to detach the screen.", "Have git pull running every X seconds, with GNU Screen"))
        users.add(GitCommandsModel("git for-each-ref --sort=-committerdate refs/heads/ | head", "See recently used branches (i.e. branches ordered by most recent commit)"))
        users.add(GitCommandsModel("cd ..\n" +
                "tar cJf project.tar.xz project/ --exclude-vcs", "Tar project files, excluding .git directory"))
        users.add(GitCommandsModel("git diff --name-only | xargs tar -cf project.tar -T -", "Tar all locally modified files"))
        users.add(GitCommandsModel("grep -H -r \"<<<\" *\n" +
                "grep -H -r \">>>\" *\n" +
                "grep -H -r '^=======\$' *", "Look for conflicts in your current files"))
        users.add(GitCommandsModel("patch -p1 < file.patch", "Apply a patch not using git:"))
        users.add(GitCommandsModel("git rev-parse --show-toplevel", "Get the git root directory"))
        users.add(GitCommandsModel("git clean -f\n" +
                "Including directories:\n" +
                "\n" +
                "git clean -f -d\n" +
                "Preventing sudden cardiac arrest:\n" +
                "\n" +
                "git clean -n -f -d", "Delete all untracked files"))

        users.add(GitCommandsModel("git ls-files --stage \n" +
                "git ls-files --cached \n" +
                "git ls-files --modified \n" +
                "git ls-files --others \n" +
                "git ls-files --deleted \n" +
                "git ls-files --unmerged \n" +
                "git ls-files --killed ", "List files staged. \n" +
                "List cached files. \n" +
                "List modified files. \n" +
                "List other (un-tracked) files. \n" +
                "List deleted files. \n" +
                "List un-merged files. \n" +
                "List killed files that need to be removed due to file/directory conflicts for checkout-index to succeed."))
        users.add(GitCommandsModel("git log \n" +
                "git log --oneline \n" +
                "git log directory/path/file \n" +
                "git log --author=\"name\" \n" +
                "git log --graph --decorate --oneline", "Show the Git log messages. \n" +
                "--oneline: brief description \n" +
                "--graph --decorate: display branching like gitk except for text terminals. \n" +
                "Note that the letter \"q\" will quit pagination mode."))
        users.add(GitCommandsModel("git clean -df \n" +
                "git clean -df \n" +
                "git -n clean \n" +
                "git -dn clean", "Remove files not managed by Git. \n" +
                "-df: All unchecked files and directories are removed. \n" +
                "-n: Dry run. Command not executed. \n" +
                "-d: directories \n" +
                "Clean has nothing to do with an Ant target of \"clean\" and is in no way related. Also see git gc"))
        users.add(GitCommandsModel("git blame filename\t", "Show file line numbers annotated with author information. Also see git log"))
        users.add(GitCommandsModel("git --help", "List Git commands"))
        users.add(GitCommandsModel("git --help command\t", "Help on given \"command\""))
        users.add(GitCommandsModel("git add path/filename\n" +
                "git add file1 file2 file3 \n" +
                "git add --update \n" +
                "git add --all", "Add a file or directory to Git CM control. This does not commit the files to the repository but merely adds files to \"staging\" status.\n" +
                "Must also perform: git commit to enter changes in the repository. \n" +
                "View staged files: git ls-files --stage \n" +
                "Empty directories are not added. Git manages files only. \n" +
                "--update: stage all tracked and modified files. \n" +
                "Undo an add: git reset HEAD path/filename"))
        users.add(GitCommandsModel("git reset HEAD^ path/filename \n" +
                "git reset HEAD~1 path/filename \n" +
                "git reset --hard HEAD^ path/filename", "Remove from staging (local copy of files still modified) \n" +
                "--hard: Don't keep changes, remove modifications to files. \n" +
                "HEAD^: latest commit notation for Linux and bash shell terminals. \n" +
                "HEAD~1: latest commit notation for Microsoft CMD shell. Microsoft DOS shell does not support \"^\".\n" +
                "Reset the repo to the last good commit specified and ignoring everything after e3b43d63: \n" +
                "git reset --hard e3b43d63 \n" +
                "git push –force \n" +
                "--hard : will erase your local work if you have anything stashed. \n" +
                "--mixed : Unstaging all changes but leave them in the working directory (default). \n" +
                "--soft : staged and working directory are not altered"))
        users.add(GitCommandsModel("git revert HEAD\t", "\tNot a commit undo but overwrites the commit with a new commit to reverse changes. Usually better to use \"git reset --hard HEAD^ path/filename\" when you want to abort your changes to a file. If you are trying to get back to a previously committed state, just use git checkout e3b43d63"))



        //creating our adapter
        val adapter = GitCommandsAdapter(users)
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
         * @return A new instance of fragment GitHubCommandsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GitHubCommandsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
