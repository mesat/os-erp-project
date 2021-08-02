export default [{
    _name: "CSidebarNav",
    _children: [
        {
            _name: "CSidebarNavItem",
            name: "+ New Employee",
            _class: "bg-success",
            to: "new",
        }, {
            _name: "CSidebarNavItem",
            name: "Employees",
            to: "table",

        }, {
            _name: "CSidebarNavItem",
            name: "Third",
            to: "/",

        }
    ]
}
]