# spring-mongodb-practice
This is a Spring core with mongodb practice.

# Start MongoDB
```bash
docker run -d --name spring-mongodb-p1 \
           -p 27017:27017 \
           --env MONGO_INITDB_ROOT_USERNAME=admin \
           --env MONGO_INITDB_ROOT_PASSWORD=secret \
           --network host \
           mongo:7
```

# Start java application
```bash
mvn compile exec:java -Dexec.mainClass="edu.man.spring.nosql.MainApplication" -Dexec.cleanupDaemonThreads=false
```



# Open MongoDB Shell
```bash
docker exec -it spring-mongodb-p1 bash
root@docker-desktop:/# mongosh -u admin -p secret --authenticationDatabase admin my-db
root@docker-desktop:/# my-db> use my-db
root@docker-desktop:/# my-db> db.createCollection("posts")
root@docker-desktop:/# my-db> db.posts.insertOne({"title": "Hello World", body: "This is my first post", category: "general", createdDate: new Date()})
root@docker-desktop:/# my-db> db.posts.insertMany([{"title": "Spring Boot", body: "Spring Boot is great", category: "tech", createdDate: new Date()},{"title": "MongoDB", body: "MongoDB is a NoSQL database", category: "tech", createdDate: new Date()},{"title": "Father", body: "My father name is Ravikumar", category: "family", createdDate: new Date()},{"title": "Mother", body: "My mother name is Mary Roselin", category: "family", createdDate: new Date()}])
root@docker-desktop:/# my-db> db.getCollection("posts").find({"category":"family"})
root@docker-desktop:/# my-db> db.posts.find({_id: { $gte: ObjectId('688b27d5ade2708bb474e39a')}})
root@docker-desktop:/# my-db> db.posts.find({ $or: [{ category: 'family' }, { title: 'Hello World' }] })
root@docker-desktop:/# my-db> db.posts.find({_id: { $gte: ObjectId('688b27d5ade2708bb474e39a')}, $or: [{ category: 'family' }, { title: 'Hello World' }]})
root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> 

root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> db.createCollection("family")
root@docker-desktop:/# my-db> db.family.insertMany([{name:'manoj',relation:'self',gender:'M',age:36,sibling:0,children:2},{name:'ravikumar',relation:'dad',gender:'M',age:65,sibling:7,children:1},{name:'mary',relation:'mom',gender:'F',age:60,sibling:3,children:1},{name:'sanjana',relation:'wife',gender:'F',age:32,sibling:1,children:2},{name:'adlin',relation:'daughter',gender:'F',age:6,sibling:1,children:0},{name:'asher',relation:'son',gender:'M',age:2,sibling:1,children:0}])
root@docker-desktop:/# my-db> db.family.insertMany([{name:'salin',relation:'mom-in-law',gender:'F',age:56,sibling:4,children:2},{name:'amirtharaj',relation:'dad-in-law',gender:'M',age:63,sibling:5,children:2},{name:'anjana',relation:'sister-in-law',gender:'F',age:30,sibling:1,children:1},{name:'naveen',relation:'co-brother',gender:'M',age:31,sibling:1,children:1},{name:'jeswin',relation:'nephew',gender:'M',age:2,sibling:0,children:0},{name:'ruby',relation:'maternal-grand-mom',gender:'F',age:76,sibling:6,children:4},{name:'manuel',relation:'maternal-grand-dad',gender:'M',age:80,sibling:3,children:4},{name:'shobana',relation:'paternal-grand-mom',gender:'F',age:80,sibling:2, children:4},{name:'chokkalingam',relation:'paternal-grand-dad',gender:'M',age:90,sibling:3, children:8}])
root@docker-desktop:/# my-db> db.family.find().size()
root@docker-desktop:/# my-db> db.family.help()
root@docker-desktop:/# my-db> db.family.find().constructor.name
root@docker-desktop:/# my-db> Object.getOwnPropertyNames(Object.getPrototypeOf(db.family.find()));
root@docker-desktop:/# my-db> db.family.count()
root@docker-desktop:/# my-db> db.family.dataSize()
root@docker-desktop:/# my-db> db.family.find().forEach(doc => {print(" Name is "+doc.name);});
root@docker-desktop:/# my-db> const randomIntFromInterval = (min, max) => { return Math.floor(Math.random() * (max - min + 1)) + min; }; db.family.find().forEach(doc => {print(" Name is "+doc.name); db.family.updateOne({ _id: doc._id}, { $set : { score: randomIntFromInterval(2,9) } }); print("score is "+doc.score);});
root@docker-desktop:/# my-db> db.family.find({children: {$gt:2}}).forEach(doc => {print(""+doc.name+" has "+doc.children+" childrens.");});
root@docker-desktop:/# my-db> db.family.find({children: {$lte:2}, age: {$gt:20}}).forEach(doc => {print(""+doc.name+" has "+doc.children+" childrens.");})
root@docker-desktop:/# my-db> const colorArr = ["red", "green", "blue", "violet", "indigo", "yellow", "orange"]; const randomChoice = () => { return colorArr[Math.floor(Math.random() * (colorArr.length + 1)) % colorArr.length]; };
root@docker-desktop:/# my-db> const randomIntFromInterval = (min, max) => { return Math.floor(Math.random() * (max - min + 1)) + min; }; const colorArr = ["red", "green", "blue", "violet", "indigo", "yellow", "orange"]; const randomChoice = () => { return colorArr[Math.floor(Math.random() * (colorArr.length + 1)) % colorArr.length]; }; 
db.family.find().forEach ( doc => db.family.updateOne({_id: doc._id}, { $set : { colors: [ randomChoice(), randomChoice() ], vals: [ randomIntFromInterval(1,100), randomIntFromInterval(2,10) ] }}));
root@docker-desktop:/# my-db> db.family.find( {vals: { $elemMatch : { $gte:10, $lte:20 }}})
root@docker-desktop:/# my-db> db.family.find( {colors: { $all : ['yellow','red']}})
root@docker-desktop:/# my-db> db.family.find().forEach ( doc => db.family.updateOne({_id: doc._id}, { $set : { item: { colors: [ randomChoice(), randomChoice() ], price: [ randomIntFromInterval(1,100), randomIntFromInterval(2,10) ] } }})) 
root@docker-desktop:/# my-db> db.family.find().forEach(doc => { const qty = randomIntFromInterval(2, 99); db.family.updateOne( { _id: doc._id }, { $set: { "item.qty2": qty } } ); });
root@docker-desktop:/# my-db> db.family.find({age:{$gte:60}}, {"item.colors":{ $slice: 1}})
root@docker-desktop:/# my-db> db.version()
root@docker-desktop:/# my-db> db.family.aggregate([{ $addFields: { gender: { $switch: { branches: [ { case: { $eq: ["$gender", "M"] }, then: "Male" }, { case: { $eq: ["$gender", "F"] }, then: "Female" } ], default: "$gender" } } } }, { $merge: { into: "family" } }]);
root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> 
root@docker-desktop:/# my-db> 
```