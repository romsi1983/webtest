ToDo:

 - Null values on edit Computer.
    Acceptance criteria: null values are saved fine.
    (Actual result: pass)
 - Add test with creating same computers (2 same computers). 
    Acceptance criteria: fail on creating second computer. 
    (Actual result: fail)
 - Add test with adding vulnerabilities check (sql injection,cross site scripting.) on edit computer. 
    Acceptance criteria: no reaction on injections.
    (Was tested with 
        <script> function myFunc(){alert("alert");}</script> 
        - passed) 
 - Create computer with special symbols (like: ~!@#$%^&*()_+). 
    Acceptance criteria: document would be created and found.
    (Actual result: failed. Document was not found)
- Create/Edit computer where introduced date is less then discontinued date. 
    Acceptance criteria: create/edit fails.
    (Actual resultL failed. It is possible to create/edit computer with this condition)
- Put date with wrong format on edit. 
    Acceptance criteria: create/edit computer fails.
    (Actual result: pass)
- Do search by large string (increase from 256 symbols to 4096). 
    Acceptance criteria: search filter should be cut on error should be generated like wrong search filter.
    (Actual result: server fails with application error.)
- Create document with large string in name
    Acceptance criteria: name be cut to reasonable number of symbols on error should be generated like: 
    "wrong computer name. Max length is 64 symbols."
    (Actual result: server fails with application error)
- Filter data (by Computer name/Introduced/Discontinued/Company). 
    -> For this test need more implementation.
    Acceptance criteria: data is filters as expected
    (Actual result: fail)
- List Pages and Check if number of shown PC = info in status bar
    -> For this test need more implementation.
    Acceptance criteria: correct info in info bar
    (Actual result: pass)
- Check that arrow are grayed in first last pages
    -> For this test need more implementation.
    Acceptance criteria: arrow are greyed
    (Actual result: pass)
- Clicking on 'Play sample application — Computer database' return on main page.
    Acceptance criteria: main page is shown with any filter
    (Actual result pass)
- Check that date is parsed correct
    Acceptance criteria: date is parsed correct
    -> For this test need to improve error handler on parsing date and implement random date
    for computers.
    (Actual result is pass)

