Sub ShowAutoFilterCriteria()
'Updateby20140219
Dim xFilter As AutoFilter
Dim TargetFilter As Filter
Dim TargetField As String
Dim xOut As String
Dim OutRng As Range
If ActiveSheet.AutoFilterMode = False Then
    Application.StatusBar = False
    Exit Sub
End If
xTitleId = "KutoolsforExcel"
Set OutRng = Application.Selection
Set OutRng = Application.InputBox("Cell", xTitleId, OutRng.Address, Type:=8)
Set xFilter = ActiveSheet.AutoFilter
For i = 1 To xFilter.Filters.Count
   TargetField = xFilter.Range.Cells(1, i).Value
   Set TargetFilter = xFilter.Filters(i)
   If TargetFilter.On Then
        On Error GoTo OutNext
        xOut = xOut & TargetField & TargetFilter.Criteria1 & "~"
        Select Case TargetFilter.Operator
            Case xlAnd
            xOut = xOut & " And " & TargetField & TargetFilter.Criteria2
            Case xlOr
            xOut = xOut & " Or " & TargetField & TargetFilter.Criteria2
            Case xlBottom10Items
            xOut = xOut & " (bottom 10 items)"
            Case xlBottom10Percent
            xOut = xOut & " (bottom 10%)"
            Case xlTop10Items
            xOut = xOut & " (top 10 items)"
            Case xlTop10Percent
            xOut = xOut & " (top 10%)"
        End Select
    End If
Next
OutRng.Value = xOut
OutNext:
xOut = xOut & TargetField & "= Multiple Filters"
ErrorHandler:
Resume Next
End Sub
