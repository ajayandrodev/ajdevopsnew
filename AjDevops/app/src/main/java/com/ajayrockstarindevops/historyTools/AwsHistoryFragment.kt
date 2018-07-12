package com.ajayrockstarindevops.historyTools


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
import com.ajayrockstarindevops.adapter.AwsAdapter.AwsHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.AwsModel.AwsHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_aws_history.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AwsHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AwsHistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mAdView : AdView

    // https://d1.awsstatic.com/whitepapers/AWS_DevOps.pdf
    // https://searchaws.techtarget.com/definition/Amazon-Web-Services
    ///https://jumpcloud.com/blog/what-is-aws/
    //https://intellipaat.com/tutorial/amazon-web-services-aws-tutorial/compute/
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
        val view = inflater.inflate(R.layout.fragment_aws_history, container, false)
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
        val users = ArrayList<AwsHistoryModel>()

        users.add(AwsHistoryModel("ABOUT AWS", "AWS launched in 2006 from the internal infrastructure that Amazon.com built to handle its online retail operations. AWS was one of the first companies to introduce a pay-as-you-go cloud computing model that scales to provide users with compute, storage or throughput as needed.\n" +
                "\n" +
                "Amazon Web Services provides services from dozens of data centers spread across availability zones (AZs) in regions across the world. An AZ represents a location that typically contains multiple physical data centers, while a region is a collection of AZs in geographic proximity connected by low-latency network links. An AWS customer can spin up virtual machines (VMs) and replicate data in different AZs to achieve a highly reliable infrastructure that is resistant to failures of individual servers or an entire data center.\n" +
                "\n" +
                "More than 100 services comprise the Amazon Web Services portfolio, including those for compute, databases, infrastructure management, application development and security. These services, by category, include:", "* Compute and Networking Services\n" +
                "* Storage and Content Delivery Services\n" + "* Migration\n" +
                "* Security and Identity Services\n" +
                "* Database Services\n" +
                "* Analytics Services\n" +
                "* Application Services\n" + "* Messaging\n" +
                "* Management Tools"))

        users.add(AwsHistoryModel("Compute", "The Compute domain includes services related to compute workloads, it includes the following services:\n" +
                "\n" +
                "* EC2 (Elastic Compute Cloud)\n" +
                "* Lightsail\n" +
                "* Elastic Container Service\n" +
                "* EKS\n" +
                "* Lambda\n" +
                "* Batch\n" +
                "* Elastic Beanstalk", "Amazon Elastic Compute Cloud (EC2) provides virtual servers -- called instances -- for compute capacity. The EC2 service offers dozens of instance types with varying capacities and sizes, tailored to specific workload types and applications, such as memory-intensive and accelerated-computing jobs. AWS also provides an Auto Scaling tool to dynamically scale capacity to maintain instance health and performance.\n" +
                "\n" +
                "The Amazon EC2 Container Service and EC2 Container Registry enable customers to work with Docker containers and images on the AWS platform. A developer can also use AWS Lambda for serverless functions that automatically run code for applications and services, as well as AWS Elastic Beanstalk for PaaS. AWS also includes Amazon Lightsail, which provides virtual private servers, and AWS Batch, which processes a series of jobs."))
        users.add(AwsHistoryModel("Storage", "The Storage domain includes services related data storage, it includes the following services:\n" +
                "\n" +
                "* S3 (Simple Storage Service)\n" +
                "* Elastic Block Store\n" +
                "* Amazon Glacier\n" +
                "* AWS Snowball\n" +
                "* EFS\n" +
                "* Storage Gateway", "Amazon Simple Storage Service (S3) provides scalable object storage for data backup, archival and analytics. An IT professional stores data and files as S3 objects -- which can range up to 5 GB -- inside S3 buckets to keep them organized. A business can save money with S3 through its Infrequent Access storage tier or use Amazon Glacier for long-term cold storage.\n" +
                "\n" +
                "Amazon Elastic Block Store provides block-level storage volumes for persistent data storage for use with EC2 instances, while Amazon Elastic File System offers managed cloud-based file storage.\n" +
                "\n" +
                "A business can also migrate data to the cloud via storage transport devices, such as AWS Snowball and Snowmobile, or use AWS Storage Gateway to enable on-premises apps to access cloud data."))
        users.add(AwsHistoryModel("Database", "The Database domain is used for database related workloads, it includes the following services:\n" +
                "\n" +
                "* Amazon Aurora\n" +
                "* Amazon RDS\n" +
                "* Amazon DynamoDB\n" +
                "* Amazon RedShift\n" +
                "* ElastiCache\n" +
                "* Neptune", "AWS provides managed database services through its Amazon Relational Database Service, which includes options for Oracle, SQL Server, PostgreSQL, MySQL, MariaDB and a proprietary high-performance database called Amazon Aurora. AWS offers managed NoSQL databases through Amazon DynamoDB.\n" +
                "\n" +
                "An AWS customer can use Amazon ElastiCache and DynamoDB Accelerator as in-memory data caches for real-time applications. Amazon Redshift offers a data warehouse, which makes it easier for data analysts to perform business intelligence tasks."))
        users.add(AwsHistoryModel("Migration ", "The Migration domain is used for transferring data to or from the AWS Infrastructure, it includes the following services:\n" +
                "\n" +
                "* AWS Migration Hub\n" +
                "* Application Discovery Service\n" +
                "* Database Migration Service\n" +
                "* Server Migration Service\n" +
                "* Snowball", "AWS includes various tools and services designed to help users migrate applications, databases, servers and data onto its public cloud. The AWS Migration Hub provides a location to monitor and manage migrations from on premises to the cloud. Once in the cloud, EC2 Systems Manager helps an IT team configure on-premises servers and AWS instances.\n" +
                "\n" +
                "Amazon also has partnerships with several technology vendors that ease hybrid cloud deployments. VMware Cloud on AWS brings software-defined data center technology from VMware to the AWS cloud. Red Hat Enterprise Linux for Amazon EC2 is the product of another partnership, extending Red Hat's operating system to the AWS cloud."))
        users.add(AwsHistoryModel("Networking & Content Delivery", "The Networking & Content Delivery domain is used for isolating your network infrastructure, and content delivery is used for faster delivery of content. It includes the following services:\n" +
                "\n" +
                "* VPC\n" +
                "* CloudFront\n" +
                "* Route 53\n" +
                "* API Gateway\n" +
                "* Direct Connect", "An Amazon Virtual Private Cloud (VPC) gives an administrator control over a virtual network to use an isolated section of the AWS cloud. AWS automatically provisions new resources within a VPC for extra protection.\n" +
                "\n" +
                "Admins can balance network traffic with AWS load balancing tools, including Application Load Balancer and Network Load Balancer. AWS also provides a domain name system called Amazon Route 53 that routes end users to applications.\n" +
                "\n" +
                "An IT professional can establish a dedicated connection from an on-premises data center to the AWS cloud via AWS Direct Connect."))
        users.add(AwsHistoryModel("Management Tools", "The Management Tools domain consists of services which are used to manage other services in AWS, it includes the following services:\n" +
                "\n" +
                "* CloudWatch\n" +
                "* AWS Auto Scaling\n" +
                "* CloudFormation\n" +
                "* CloudTrail\n" +
                "* Config\n" +
                "* OpsWorks\n" +
                "* Service Catalog\n" +
                "* Systems Manager\n" +
                "* Trusted Advisor\n" +
                "* Managed Services", "An admin can manage and track cloud resource configuration via AWS Config and AWS Config Rules. Those tools, along with AWS Trusted Advisor, can help an IT team avoid improperly configured and needlessly expensive cloud resource deployments.\n" +
                "\n" +
                "AWS provides several automation tools in its portfolio. An admin can automate infrastructure provisioning via AWS CloudFormation templates, and also use AWS OpsWorks and Chef to automate infrastructure and system configurations.\n" +
                "\n" +
                "An AWS customer can monitor resource and application health with Amazon CloudWatch and the AWS Personal Health Dashboard, and also use AWS CloudTrail to retain user activity and application programming interface (API) calls for auditing."))

        users.add(AwsHistoryModel("Security & Identity, Compliance", "The Security & Identity, Compliance domain consist of services which are used to manage to authenticate and provide security to your AWS resources. It consists of the following services:\n" +
                "\n" +
                "\n" +
                "* IAM\n" +
                "* Cognito\n" +
                "* Secrets Manager\n" +
                "* GuardDuty\n" +
                "* Inspector\n" +
                "* Amazon Macie\n" +
                "* AWS Single Sign-On\n" +
                "* Certificate Manager\n" +
                "* CloudHSM\n" +
                "* Directory Service\n" +
                "* WAF & Shield\n" +
                "* Artifact", "AWS provides a range of services for cloud security, including AWS Identity and Access Management (IAM), which allows admins to define and manage user access to resources. An admin can also create a user directory with Amazon Cloud Directory, or connect cloud resources to an existing Microsoft Active Directory with the AWS Directory Service. Additionally, AWS Organizations enables a business to establish and manage policies for multiple AWS accounts.\n" +
                "\n" +
                "The cloud provider has also introduced tools that automatically assess potential security risks. Amazon Inspector analyzes an AWS environment for vulnerabilities that might impact security and compliance. Amazon Macie uses machine learning technology to protect sensitive cloud data.\n" +
                "\n" +
                "AWS also includes tools and services that provide software- and hardware-based encryption, protect against DDoS attacks, provision Secure Sockets Layer and Transport Layer Security certificates and filter potentially harmful traffic to web applications."))
        users.add(AwsHistoryModel("Messaging ", "The Messaging domain consists of services which are used for queuing, notifying or emailing messages. It consists of the following domains:\n" +
                "\n" +
                "* Amazon SQS\n" +
                "* Amazon SNS\n" +
                "* Amazon SES\n" +
                "* Amazon Pinpoint", "AWS messaging services provide core communication for users and applications. Amazon Simple Queue Service is a managed message queue that sends, stores and receives messages between components of distributed applications to ensure that the parts of an application work as intended.\n" +
                "\n" +
                "Amazon Simple Notification Service (SNS) enables a business to send pub-sub messages to endpoints, such as end users or services. SNS includes a mobile messaging feature that enables push messaging to mobile devices. Amazon Simple Email Service provides a platform for IT professionals and marketers to send and receive emails.\n" +
                "\n" +
                "Amazon SQS \n" +
                "\n" +
                "Amazon Simple Queue Service (Amazon SQS) is a fast, reliable, scalable, fully managed message queuing service. Amazon SQS makes it simple and cost-effective to decouple the components of a cloud application. You can use Amazon SQS to transmit any volume of data, without losing messages or requiring other services to be always available. Amazon SQS includes standard queues with high throughput and at-least-once processing, and FIFO queues that provide FIFO (first-in, first-out) delivery and exactly-once processing.\n" +
                "\n" +
                "Amazon SNS \n" +
                "\n" +
                "Amazon Simple Notification Service (Amazon SNS) is a fast, flexible, fully managed push notification service that lets you send individual messages or to fan-out messages to large numbers of recipients. Amazon SNS makes it simple and cost effective to send push notifications to mobile device users, email recipients or even send messages to other distributed services.\n" +
                "\n" +
                "With Amazon SNS, you can send notifications to Apple, Google, Fire OS, and Windows devices, as well as to Android devices in China with Baidu Cloud Push. You can use Amazon SNS to send SMS messages to mobile device users worldwide.\n" +
                "\n" +
                "Beyond these endpoints, Amazon SNS can also deliver messages to Amazon Simple Queue Service (SQS), AWS Lambda functions, or to any HTTP endpoint.\n" +
                "\n" +
                "Amazon SES \n" +
                "\n" +
                "Amazon Simple Email Service (Amazon SES) is a cost-effective email service built on the reliable and scalable infrastructure that Amazon.com developed to serve its own customer base. With Amazon SES, you can send transactional email, marketing messages, or any other type of high-quality content to your customers. You can also use Amazon SES to receive messages and deliver them to an Amazon S3 bucket, call your custom code via an AWS Lambda function, or publish notifications to Amazon SNS. With Amazon SES, you have no required minimum commitments—you pay as you go, and you only pay for what you use.\n" +
                "\n" +
                "Amazon Pinpoint\n" +
                "\n" +
                "Amazon Pinpoint makes it easy to run targeted campaigns to drive user engagement in mobile apps. Amazon Pinpoint helps you understand user behavior, define which users to target, determine which messages to send, schedule the best time to deliver the messages, and then track the results of your campaign.\n" +
                "\n" +
                "Targeted push notifications based on app usage trends and user behavior have become a popular approach for mobile app user engagement because response rates are often several times higher than traditional email marketing campaigns. By using targeted push notifications, you can increase message relevance and effectiveness, measure engagement, and continually improve your campaigns.\n" +
                "\n" +
                "Getting started with Amazon Pinpoint is easy. First, AWS Mobile Hub guides you through the process to integrate the AWS Mobile SDK with your app. Next, you define your target segments, campaign message, and specify the delivery schedule. Once your campaign is running, Pinpoint provides metrics so you can run analytics and track the impact of your campaign.\n" +
                "\n" +
                "With Amazon Pinpoint, there are no upfront setup costs, and no fixed monthly cost. You only pay for the number of users your campaign targets, the messages you send, and the events you collect, so you can start small and scale as your application grows."))
        users.add(AwsHistoryModel("Development Tools", "The Developer Tools domain includes the following services:\n" +
                "\n" +
                "* CodeStar\n" +
                "* CodeCommit\n" +
                "* CodeBuild\n" +
                "* CodeDeploy\n" +
                "* CodePipeline\n" +
                "* Cloud9\n" +
                "* X-Ray", "A developer can take advantage of AWS command-line tools and software development kits (SDKs) to deploy and manage applications and services. The AWS Command Line Interface is Amazon's proprietary code interface. A developer can also use AWS Tools for Powershell to manage cloud services from Windows environments and AWS Serverless Application Model to simulate an AWS environment to test Lambda functions. AWS SDKs are available for a variety of platforms and programming languages, including Java, PHP, Python, Node.js, Ruby, C++, Android and iOS.\n" +
                "\n" +
                "Amazon API Gateway enables a development team to create, manage and monitor custom APIs that let applications access data or functionality from back-end services. API Gateway manages thousands of concurrent API calls at once.  \n" +
                "\n" +
                "AWS also provides a packaged media transcoding service, Amazon Elastic Transcoder, and a service that visualizes workflows for microservices-based applications, AWS Step Functions.\n" +
                "\n" +
                "A development team can also create continuous integration and continuous delivery pipelines with services like AWS CodePipeline, AWS CodeBuild, AWS CodeDeploy and AWS CodeStar. A developer can also store code in Git repositories with AWS CodeCommit and evaluate the performance of microservices-based applications with AWS X-Ray."))
        users.add(AwsHistoryModel("Analytics", "The Analytics Tools domain includes the following services:\n" +
                "\n" +
                "* Athena\n" +
                "* EMR\n" +
                "* CloudSearch\n" +
                "* Elasticsearch Service\n" +
                "* Kinesis\n" +
                "* QuickSight\n" +
                "* Data Pipeline\n" +
                "* AWS Glue", "AWS includes a variety of big data analytics and application services. Amazon Elastic MapReduce offers a Hadoop framework to process large amounts of data, while Amazon Kinesis provides several tools to process and analyze streaming data.\n" +
                "\n" +
                "AWS Glue is a service that handles extract, transform and load jobs, while the Amazon Elasticsearch Service enables a team to perform application monitoring, log analysis and other tasks with the open source Elasticsearch tool.\n" +
                "\n" +
                "To query data, an analyst can use Amazon Athena for S3, and then visualize data with Amazon QuickSight.\n" +
                "\n" +
                "Amazon EMR \t\n" +
                "\n" +
                "It uses Hadoop, which is an open source framework, for managing and processing data. It uses the MapReduce engine to distribute processing using a cluster.\n" +
                "\n" +
                "AWS Data Pipeline\n" +
                "\n" +
                "It helps in regularly moving and processing data. Using a pipeline, we define the input data source, the computing resources in order to perform the processing, any conditions that must be validated before performing any processing is also defined, and  the output data location such as Amazon S3, Amazon DynamoDB etc is to be defined.\n" +
                "\n" +
                "Amazon Kinesis\t\n" +
                "\n" +
                "Amazon Kinesis allows real-time processing of streaming data at a humongous scale. One can also send data from Amazon Kinesis to a data warehouse, such as Amazon S3 or Amazon Redshift or to an Amazon EMR cluster.\n" +
                "\n" +
                "Amazon ML\n" +
                "\n" +
                "By the use of Amazon ML, developers can easily use machine learning technology for obtaining predictions for their applications by using simple APIs."))
        users.add(AwsHistoryModel("Internet Of Things", "The Internet Of Things domain includes the following services:\n" +
                "\n" +
                "* IoT Core\n" +
                "* IoT 1-Click\n" +
                "* IoT Device Management\n" +
                "* IoT Analytics\n" +
                "* Greengrass\n" +
                "* Amazon FreeRTOS", "The AWS IoT acts as the mediator between the components and the network.  It hence, gathers information from those things and works on them. AWS IoT is defined as a platform which enables you to connect devices to AWS Services along with the other devices, secure data and interactions, process and act upon device data, and also allows applications to interact with devices even when they are offline.\n" +
                "\n" +
                "AWS IoT has the following gears :\n" +
                "\n" +
                "Message broker\n" +
                "\n" +
                "It gives safety for the IoT and its uses. For issuing and donating we have to use MQTT and HTTP Rest IP.\n" +
                "\n" +
                "Rules engine\n" +
                "\n" +
                "Correlation of different services of the same kind is done by the rules engine. For processing and transferring information, SQL-based code  like Amazon S3,DB,Lambda, etc. has to be choosen.\n" +
                "\n" +
                "Thing shadow\t\n" +
                "\n" +
                "It is also called as a device shadow. It gives the present data of any component connected to IoT. For that a JSON material is used.\n" +
                "\n" +
                "Security and identity service\t\n" +
                "\n" +
                "It takes care of the protection in a shared basis. The message transfer to and from the things  are done using these services with confidential credentials.\n" +
                "\n" +
                "Device gateway\t\n" +
                "\n" +
                "It allows  the gadgets to interact with the IoT in a safe and sound environment."))
        users.add(AwsHistoryModel("Mobile Services", "The Mobile Services domain includes the following services:\n" +
                "\n" +
                "* Mobile Hub\n" +
                "* AWS AppSync\n" +
                "* Device Farm\n" +
                "* Mobile Analytics", "The AWS Mobile Hub offers a collection of tools and services for mobile app developers, including the AWS Mobile SDK, which provides code samples and libraries.\n" +
                "\n" +
                "A mobile app developer can also use Amazon Cognito to manage user access to mobile apps, as well as Amazon Pinpoint to send push notifications to application end users and then analyze the effectiveness of those communications.\n" +
                "\n" +
                "Amazon Cognito finds out ways to recognize sole users, recover provisional ,unimportant passwords and helps in information management operations.\n" +
                "\n" +
                "To initiate with Cognito, the steps are:\n" +
                "\n" +
                "Register in AWS.\n" +
                "Get the token of your application.\n" +
                "Develop an identity pool for Cognito.\n" +
                "Develop SDK , accumulate and then synchronize the information.\n" +
                "The maximum size of the dataset is 1 MB and that of the identity is 20 MB.\n" +
                "\n" +
                "Developing a dataset and and put keys is done by the following command:\n" +
                "\n" +
                "DataSet *dataset = [syncClient openOrCreateDataSet:@”myDataSet”];\n" +
                "\n" +
                "NSString *value = [dataset readStringForKey:@”myKey”];[dataset putString:@”my value” forKey:@”myKey”];\n" +
                "\n" +
                "As the applications in the cloud increases, the cost of Cognito also increases. We will be able to use use 10 GB of storeroom for the first year.\n" +
                "\n" +
                "The mobile SDK allows easy building of the AWS applications. A Few characteristics of them are as follows:\n" +
                "\n" +
                "Object Mapper\n" +
                "\n" +
                "It helps in admitting the DynamoDB from the applications. It assists us to program for converting substance into tables and vice versa. The substances allow reading, writing and removing services on the items and support questions.\n" +
                "\n" +
                "Read this blog now to know how to Aim High with a Career in Cloud Computing.\n" +
                "\n" +
                "S3 Transfer Manager\n" +
                "\n" +
                "It helps for uploading and downloading documents from S3 by increasing the performance level and dependency. Operations on file transfer now can be further modified. Using BFTask this tool is repaired and now transformed into a better and cleaner boundary.\n" +
                "\n" +
                "iOS / Objective-C Enhancements\n" +
                "\n" +
                "The Mobile SDK helps ARC with BFTask for better utilization of Objective C. and Cocoapods."))
        //creating our adapter
        val adapter = AwsHistoryAdapter(users)
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
         * @return A new instance of fragment AwsHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                AwsHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
