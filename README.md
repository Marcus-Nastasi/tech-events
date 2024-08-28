<mxfile host="app.diagrams.net" agent="Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36" version="24.7.7">
  <diagram id="C5RBs43oDa-KdzZeNtuy" name="Page-1">
    <mxGraphModel dx="1434" dy="788" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1169" pageHeight="827" math="0" shadow="0">
      <root>
        <mxCell id="WIyWlLk6GJQsqaUBKTNV-0" />
        <mxCell id="WIyWlLk6GJQsqaUBKTNV-1" parent="WIyWlLk6GJQsqaUBKTNV-0" />
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-54" value="" style="rounded=1;whiteSpace=wrap;html=1;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="290" y="992" width="750" height="510" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-0" value="&lt;font style=&quot;font-size: 20px;&quot;&gt;MODELAGEM&lt;/font&gt;" style="rounded=1;whiteSpace=wrap;html=1;strokeColor=#6c8ebf;fillColor=#dae8fc;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="510" y="60" width="158" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-1" value="Coupon" style="swimlane;fontStyle=0;childLayout=stackLayout;horizontal=1;startSize=30;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;whiteSpace=wrap;html=1;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="350" y="250" width="180" height="180" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-2" value="+ id: UUID" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-1" vertex="1">
          <mxGeometry y="30" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-3" value="+ discount: Double" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-1" vertex="1">
          <mxGeometry y="60" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-4" value="+ code: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-1" vertex="1">
          <mxGeometry y="90" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-5" value="+ valid: Boolean" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-1" vertex="1">
          <mxGeometry y="120" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-6" value="+ event: Event" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-1" vertex="1">
          <mxGeometry y="150" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-9" value="Event" style="swimlane;fontStyle=0;childLayout=stackLayout;horizontal=1;startSize=30;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;whiteSpace=wrap;html=1;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="120" y="290" width="180" height="240" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-10" value="+ id: UUID" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="30" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-11" value="+ title: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="60" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-12" value="+ description: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="90" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-13" value="+ date: DateTime" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="120" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-14" value="+ remote: Boolean" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="150" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-15" value="+ image_url: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="180" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-16" value="+ event_url: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-9" vertex="1">
          <mxGeometry y="210" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-17" value="Address" style="swimlane;fontStyle=0;childLayout=stackLayout;horizontal=1;startSize=30;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;whiteSpace=wrap;html=1;" parent="WIyWlLk6GJQsqaUBKTNV-1" vertex="1">
          <mxGeometry x="350" y="450" width="180" height="150" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-18" value="+ id: UUID" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-17" vertex="1">
          <mxGeometry y="30" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-19" value="+ uf: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-17" vertex="1">
          <mxGeometry y="60" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-20" value="+ City: String" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-17" vertex="1">
          <mxGeometry y="90" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="HTHqtFMLv6rHSv95omAJ-22" value="+ event: Event" style="text;strokeColor=none;fillColor=none;align=left;verticalAlign=middle;spacingLeft=4;spacingRight=4;overflow=hidden;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;rotatable=0;whiteSpace=wrap;html=1;" parent="HTHqtFMLv6rHSv95omAJ-17" vertex="1">
          <mxGeometry y="120" width="180" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-0" value="&lt;div style=&quot;box-sizing:border-box;width:100%;background:#e4e4e4;padding:2px;&quot;&gt;Coupon&lt;/div&gt;&lt;table style=&quot;width:100%;font-size:1em;&quot; cellpadding=&quot;2&quot; cellspacing=&quot;0&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td&gt;PK&lt;/td&gt;&lt;td&gt;id&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;FK1&lt;/td&gt;&lt;td&gt;event_id&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;&lt;/td&gt;&lt;td&gt;discount&lt;br&gt;code&lt;br&gt;valid&lt;br&gt;&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;" style="verticalAlign=top;align=left;overflow=fill;html=1;whiteSpace=wrap;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="943" y="260" width="180" height="110" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-1" value="&lt;div style=&quot;box-sizing:border-box;width:100%;background:#e4e4e4;padding:2px;&quot;&gt;Address&lt;/div&gt;&lt;table style=&quot;width:100%;font-size:1em;&quot; cellpadding=&quot;2&quot; cellspacing=&quot;0&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td&gt;PK&lt;/td&gt;&lt;td&gt;id&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;FK1&lt;/td&gt;&lt;td&gt;event_id&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;&lt;/td&gt;&lt;td&gt;uf&lt;br&gt;city&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;" style="verticalAlign=top;align=left;overflow=fill;html=1;whiteSpace=wrap;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="943" y="420" width="180" height="90" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-7" style="rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.25;exitDx=0;exitDy=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;strokeColor=default;startArrow=ERmandOne;startFill=0;endArrow=ERzeroToOne;endFill=0;edgeStyle=entityRelationEdgeStyle;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="Xg9JaSwVXIhFdQvkE1CP-2" target="Xg9JaSwVXIhFdQvkE1CP-1">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-2" value="&lt;div style=&quot;box-sizing:border-box;width:100%;background:#e4e4e4;padding:2px;&quot;&gt;Event&lt;/div&gt;&lt;table style=&quot;width:100%;font-size:1em;&quot; cellpadding=&quot;2&quot; cellspacing=&quot;0&quot;&gt;&lt;tbody&gt;&lt;tr&gt;&lt;td&gt;PK&lt;/td&gt;&lt;td&gt;id&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;&lt;br&gt;&lt;/td&gt;&lt;td&gt;title&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;&lt;/td&gt;&lt;td&gt;description&lt;br&gt;date&lt;br&gt;remote&lt;br&gt;image_url&lt;br&gt;event_url&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;" style="verticalAlign=top;align=left;overflow=fill;html=1;whiteSpace=wrap;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="643" y="280" width="180" height="140" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-14" style="rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.25;exitDx=0;exitDy=0;entryX=-0.012;entryY=0.408;entryDx=0;entryDy=0;entryPerimeter=0;strokeColor=default;startArrow=ERmandOne;startFill=0;endArrow=ERzeroToMany;endFill=0;edgeStyle=entityRelationEdgeStyle;elbow=vertical;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="Xg9JaSwVXIhFdQvkE1CP-2" target="Xg9JaSwVXIhFdQvkE1CP-0">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-21" style="edgeStyle=entityRelationEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0;entryY=0.5;entryDx=0;entryDy=0;entryPerimeter=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="Xg9JaSwVXIhFdQvkE1CP-16" target="Xg9JaSwVXIhFdQvkE1CP-17">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="338" y="1248" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-16" value="" style="sketch=0;outlineConnect=0;fontColor=#232F3E;gradientColor=none;fillColor=#232F3D;strokeColor=none;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;fontSize=12;fontStyle=0;aspect=fixed;pointerEvents=1;shape=mxgraph.aws4.users;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="110" y="1208" width="78" height="78" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-17" value="" style="sketch=0;points=[[0,0,0],[0.25,0,0],[0.5,0,0],[0.75,0,0],[1,0,0],[0,1,0],[0.25,1,0],[0.5,1,0],[0.75,1,0],[1,1,0],[0,0.25,0],[0,0.5,0],[0,0.75,0],[1,0.25,0],[1,0.5,0],[1,0.75,0]];outlineConnect=0;fontColor=#232F3E;fillColor=#C925D1;strokeColor=#ffffff;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;fontSize=12;fontStyle=0;aspect=fixed;shape=mxgraph.aws4.resourceIcon;resIcon=mxgraph.aws4.cloud_control_api;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="420" y="1157" width="60" height="60" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-39" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.5;exitY=1;exitDx=0;exitDy=0;exitPerimeter=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="Xg9JaSwVXIhFdQvkE1CP-18" target="Xg9JaSwVXIhFdQvkE1CP-19">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-45" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;exitPerimeter=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;startArrow=classic;startFill=1;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="Xg9JaSwVXIhFdQvkE1CP-18" target="Xg9JaSwVXIhFdQvkE1CP-43">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-18" value="" style="sketch=0;points=[[0,0,0],[0.25,0,0],[0.5,0,0],[0.75,0,0],[1,0,0],[0,1,0],[0.25,1,0],[0.5,1,0],[0.75,1,0],[1,1,0],[0,0.25,0],[0,0.5,0],[0,0.75,0],[1,0.25,0],[1,0.5,0],[1,0.75,0]];outlineConnect=0;fontColor=#232F3E;fillColor=#ED7100;strokeColor=#ffffff;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;fontSize=12;fontStyle=0;aspect=fixed;shape=mxgraph.aws4.resourceIcon;resIcon=mxgraph.aws4.ec2;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="605" y="1162" width="50" height="50" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-20" value="" style="sketch=0;outlineConnect=0;fontColor=#232F3E;gradientColor=none;fillColor=#3399FF;strokeColor=none;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;fontSize=12;fontStyle=0;aspect=fixed;pointerEvents=1;shape=mxgraph.aws4.rds_postgresql_instance;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="870" y="1148" width="78" height="78" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-22" value="Internet Gatway" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="395" y="1226" width="110" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-24" value="EC2 Java Server" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="570" y="1127" width="110" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-25" value="S3 Bucket" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="646" y="1454" width="80" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-27" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;exitPerimeter=0;entryX=0;entryY=0.5;entryDx=0;entryDy=0;entryPerimeter=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1" source="Xg9JaSwVXIhFdQvkE1CP-17" target="Xg9JaSwVXIhFdQvkE1CP-18">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-32" value="" style="endArrow=none;html=1;rounded=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="350" y="1318" as="sourcePoint" />
            <mxPoint x="350" y="1058" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-33" value="" style="endArrow=none;html=1;rounded=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="350" y="1058" as="sourcePoint" />
            <mxPoint x="990" y="1058" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-34" value="" style="endArrow=none;html=1;rounded=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="990" y="1318" as="sourcePoint" />
            <mxPoint x="990" y="1058" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-38" value="Subnet Pública" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="485" y="1062" width="100" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-40" value="Upload Img" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="545" y="1358" width="80" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-41" value="Write / Read" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="702" y="1190" width="90" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-43" value="" style="rounded=1;whiteSpace=wrap;html=1;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="840" y="1117" width="130.5" height="140" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-46" value="&lt;font style=&quot;font-size: 9px;&quot;&gt;Subnet Privada&lt;/font&gt;" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;fillColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="860.5" y="1117" width="90" height="30" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-48" value="" style="sketch=0;outlineConnect=0;fontColor=#232F3E;gradientColor=none;fillColor=#DD344C;strokeColor=none;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;fontSize=12;fontStyle=0;aspect=fixed;pointerEvents=1;shape=mxgraph.aws4.addon;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="850.5" y="1127" width="19.5" height="10" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-19" value="" style="sketch=0;points=[[0,0,0],[0.25,0,0],[0.5,0,0],[0.75,0,0],[1,0,0],[0,1,0],[0.25,1,0],[0.5,1,0],[0.75,1,0],[1,1,0],[0,0.25,0],[0,0.5,0],[0,0.75,0],[1,0.25,0],[1,0.5,0],[1,0.75,0]];outlineConnect=0;fontColor=#232F3E;fillColor=#7AA116;strokeColor=#ffffff;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;fontSize=12;fontStyle=0;aspect=fixed;shape=mxgraph.aws4.resourceIcon;resIcon=mxgraph.aws4.s3;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="605" y="1428" width="50" height="50" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-50" value="" style="endArrow=none;html=1;rounded=0;" edge="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="350" y="1318" as="sourcePoint" />
            <mxPoint x="990" y="1318" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-55" value="" style="outlineConnect=0;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;shape=mxgraph.aws3.cloud_2;fillColor=#F58534;gradientColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="334" y="980" width="36" height="38" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-56" value="" style="outlineConnect=0;dashed=0;verticalLabelPosition=bottom;verticalAlign=top;align=center;html=1;shape=mxgraph.aws3.virtual_private_cloud;fillColor=#F58534;gradientColor=none;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="355.25" y="1062" width="36.75" height="25" as="geometry" />
        </mxCell>
        <mxCell id="Xg9JaSwVXIhFdQvkE1CP-58" value="&lt;font style=&quot;font-size: 20px;&quot;&gt;Cloud&lt;/font&gt;" style="rounded=1;whiteSpace=wrap;html=1;strokeColor=#d79b00;fillColor=#ffe6cc;" vertex="1" parent="WIyWlLk6GJQsqaUBKTNV-1">
          <mxGeometry x="532" y="897" width="105" height="30" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>
