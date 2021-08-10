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
}