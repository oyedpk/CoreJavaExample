--replace male to female and female to male
update employee set gender = (case gender when 'male' then 'female' else 'male' end);

--display 5-7 wors
select empname from employee where rowid in
(select rowid from employee where rownum<=7 minus select rowid from employee where rownum<5);

--delete repeated rows

