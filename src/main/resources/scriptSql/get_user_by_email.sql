SELECT a.UserID, a.CustomerID, a.Email, a.Password, a.roleID, b.name RoleName
  FROM dbo.Users a, dbo.Roles b
 WHERE a.RoleID = b.RoleID 
   AND a.Email = ?