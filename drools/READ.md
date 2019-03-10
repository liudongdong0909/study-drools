# Getting Started

### Guides
The following guides illustrates how to use certain features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)

https://github.com/ityouknow/drools-examples

## 规则引擎
### 相关介绍

规则引擎起源于基于规则的专家系统，而基于规则的专家系统又是专家系统的其中一个分支。专家系统属于人工智能的范畴，它模仿人类的推理方式，使用试探性的方法进行推理，并使用人类能理解的术语解释和证明它的推理结论。

利用它就可以在应用系统中分离商业决策者的商业决策逻辑和应用开发者的技术决策，并把这些商业决策放在中心数据库或其他统一的地方，让它们能在运行时可以动态地管理和修改，从而为企业保持灵活性和竞争力提供有效的技术支持。

在需求里面我们往往把约束，完整性，校验，分支流等都可以算到业务规则里面。在规则引擎里面谈的业务规则重点是谈当满足什么样的条件的时候，需要执行什么样的操作。因此一个完整的业务规则包括了条件和触发操作两部分内容。而引擎是事物内部的重要的运行机制，规则引擎即重点是解决规则如何描述，如何执行，如何监控等一系列问题。

规则引擎由推理引擎发展而来，是一种嵌入在应用程序中的组件，实现了将业务决策从应用程序代码中分离出来，并使用预定义的语义模块编写业务决策。接受数据输入，解释业务规则，并根据业务规则做出业务决策。

java开源的规则引擎有：Drools、Easy Rules、Mandarax、IBM ILOG。使用最为广泛并且开源的是Drools。

### 规则引擎的优点

1. 声明式编程
规则可以很容易地解决困难的问题，并得到解决方案的验证。与代码不同，规则以较不复杂的语言编写; 业务分析师可以轻松阅读和验证一套规则。
2. 逻辑和数据分离
数据位于“域对象”中，业务逻辑位于“规则”中。根据项目的种类，这种分离是非常有利的。
3. 速度和可扩展性
写入Drools的Rete OO算法已经是一个成熟的算法。在Drools的帮助下，您的应用程序变得非常可扩展。如果频繁更改请求，可以添加新规则，而无需修改现有规则。
4. 知识集中化
通过使用规则，您创建一个可执行的知识库（知识库）。这是商业政策的一个真理点。理想情况下，规则是可读的，它们也可以用作文档。

### rete 算法

Rete 算法最初是由卡内基梅隆大学的 Charles L.Forgy 博士在 1974 年发表的论文中所阐述的算法 , 该算法提供了专家系统的一个高效实现。自 Rete 算法提出以后 , 它就被用到一些大型的规则系统中 , 像 ILog、Jess、JBoss Rules 等都是基于 RETE 算法的规则引擎

Rete 在拉丁语中译为”net”，即网络。Rete 匹配算法是一种进行大量模式集合和大量对象集合间比较的高效方法，通过网络筛选的方法找出所有匹配各个模式的对象和规则。

其核心思想是将分离的匹配项根据内容动态构造匹配树，以达到显著降低计算量的效果。Rete 算法可以被分为两个部分：规则编译和规则执行。当Rete算法进行事实的断言时，包含三个阶段：匹配、选择和执行，称做 match-select-act cycle。

rate算法的详细内容可以参考这篇文章：开源规则流引擎实践

## Drools 介绍
Drools 是一个基于Charles Forgy’s的RETE算法的，易于访问企业策略、易于调整以及易于管理的开源业务规则引擎，符合业内标准，速度快、效率高。 业务分析师人员或审核人员可以利用它轻松查看业务规则，从而检验是否已编码的规则执行了所需的业务规则。

Drools 是用Java语言编写的开放源码规则引擎，使用Rete算法对所编写的规则求值。Drools允许使用声明方式表达业务逻辑。可以使用非XML的本地语言编写规则，从而便于学习和理解。并且，还可以将Java代码直接嵌入到规则文件中，这令Drools的学习更加吸引人。

### Drools优点：

1. 非常活跃的社区支持
2. 易用
3. 快速的执行速度
4. 在 Java 开发人员中流行
5. 与 Java Rule Engine API（JSR 94）兼容

### Drools相关概念：

1. 事实（Fact）：对象之间及对象属性之间的关系
2. 规则（rule）：是由条件和结论构成的推理语句，一般表示为if…Then。一个规则的if部分称为LHS，then部分称为RHS。
3. 模式（module）：就是指IF语句的条件。这里IF条件可能是有几个更小的条件组成的大条件。模式就是指的不能在继续分割下去的最小的原子条件。

Drools通过 事实、规则和模式相互组合来完成工作，drools在开源规则引擎中使用率最广，但是在国内企业使用偏少，保险、支付行业使用稍多。
