export default class Employee {
    constructor(name, surName, startDate, role, bio) {
        this.name = name
        this.surName = surName
        this.date = startDate
        this.role = role
        this.bio = bio
    }
    setId(id){
        this.id = id
        return this
    }
    parse(obj){
        if(obj['name'] !== undefined)
        {
            this.name = obj['name']
        }
        if(obj['surname'] !== undefined)
        {
            this.surName = obj['surname']
        }
        if(obj['date'] !== undefined)
        {
            this.date = obj['date']
        }
        if(obj['rol'] !== undefined)
        {
            this.role = obj['role']
        }
        if(obj['bio'] !== undefined)
        {
            this.bio = obj['bio']
        }
        if(obj['id'] !== undefined)
        {
            this.id = obj['id']
        }
        return this
    }
}